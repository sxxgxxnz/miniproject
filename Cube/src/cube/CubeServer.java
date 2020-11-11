package cube;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CubeServer {
	private ServerSocket ss;
	private List<CubeHandler> list;

	public CubeServer() {
		try {
			ss = new ServerSocket(9500);
			System.out.println("���� �غ� �Ϸ�");

			list = new ArrayList<CubeHandler>();

			while (true) {
				Socket socket = ss.accept(); // ����æ��
				CubeHandler handler = new CubeHandler(socket, list);// ������ ����
				handler.start();// ������ ���� - ������ ����(run())

				list.add(handler);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CubeServer();
	}
}
