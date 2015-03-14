package data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * @author Usuario
 *
 */
public class HorarioManager {

	private static final byte[]	s			= new byte[] { 25, 32, 87, 110, 87, 34, 76, 29 };
	private static final String	FILENAME	= "horario.bin";

	/**
	 * @param horario
	 */
	public static void saveHorario(final Horario horario) {
		try {
			final FileOutputStream fos = new FileOutputStream(FILENAME);
			fos.write(getByteBuffer(horario));
			fos.close();
		} catch (final Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao salvar o horário para o arquivo");
			throw new RuntimeException(e);
		}
	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Horario loadHorario() throws FileNotFoundException {
		final File file = new File(FILENAME);
		if (!file.exists()) {
			throw new FileNotFoundException("Arquivo de Horarios não encontrado, favor gerar um novo");
		}
		try {
			final byte[] buffer = new byte[(int) file.length()];
			final FileInputStream fis = new FileInputStream(file);
			fis.read(buffer);
			fis.close();
			return loadHorario(buffer);
		} catch (final Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao carregar arquivo de Horarios");
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param horario
	 * @return
	 */
	public static byte[] getByteBuffer(final Horario horario) {
		try {
			final SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(s));

			final Cipher encrypter = Cipher.getInstance("DES/ECB/PKCS5Padding");
			encrypter.init(Cipher.ENCRYPT_MODE, secretKey);

			// Seal it, storing it in a SealedObject
			final SealedObject sealed = new SealedObject(horario, encrypter);

			final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			final ObjectOutputStream oos = new ObjectOutputStream(buffer);
			oos.writeObject(sealed);
			oos.close();
			return buffer.toByteArray();
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	/**
	 * @param buffer
	 * @return
	 */
	public static Horario loadHorario(final byte[] buffer) {
		try {
			final SecretKey secretKey = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(s));

			final Cipher decrypter = Cipher.getInstance("DES/ECB/PKCS5Padding");
			decrypter.init(Cipher.DECRYPT_MODE, secretKey);

			final SealedObject sealed = (SealedObject) new ObjectInputStream(new ByteArrayInputStream(buffer)).readObject();

			final Horario horario = (Horario) sealed.getObject(decrypter);

			return horario;
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
