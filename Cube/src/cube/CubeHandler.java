package cube;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;



public class CubeHandler extends Thread {
	private Socket socket;
	private List<CubeHandler> list;

	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public CubeHandler(Socket socket, List<CubeHandler> list) throws IOException {
		this.socket = socket;
		this.list = list;

		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		// ť��������κ��� �޴� ��
		UserDTO dto = null;
		String id = null;

		while (true) {
			try {
				dto = (UserDTO) ois.readObject();

				if (dto.getCommand() == Info.JOIN) {
					// ��� Ŭ���̾�Ʈ����(�� ����) ����޼����� ������
					UserDTO sendDTO = new UserDTO();
					sendDTO.setCommand(Info.SEND);
					id = dto.getId();
					sendDTO.setMessage(id + "�� �����Ͽ����ϴ�");
					broadcast(sendDTO);

				} else if (dto.getCommand() == Info.EXIT) {
					UserDTO sendDTO = new UserDTO();

					// quit�� ���� Ŭ���̾�Ʈ���� quit�� ������(������)
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();
					
					ois.close();
					oos.close();
					socket.close();

					// ���� Ŭ���̾�Ʈ������ ����޼��� ������
					list.remove(this);

					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(id + "�� �����Ͽ����ϴ�");
					
					broadcast(sendDTO);
				
					break;

				} else if (dto.getCommand() == Info.SEND) {
					UserDTO sendDTO = new UserDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("[" + id + "] " + dto.getMessage());
					broadcast(sendDTO);
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // while
	}

	private void broadcast(UserDTO sendDTO) {
		for (CubeHandler handler : list) {
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // for
	}

}
