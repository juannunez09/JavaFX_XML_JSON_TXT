package xom.campusfp.writer;

public class TestWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaXWriter configFile = new StaXWriter();
		configFile.setFile("config2.xml");
		try {
			configFile.saveconfig();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
