public class PhotMagicDelux 
{
	public static Picture transform(Picture pic , String password,int point)
	{	
		/*
		 *go through each character in passowrd and find the indexOF() in the base64 and convert the index into binary
		 * 
		 */
		String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		String binary = "";
		for(int i = 0; i<password.length(); i++)
		{
			int index  = base64.indexOf(password.charAt(i));
			binary += String.format("%6s", Integer.toBinaryString(index));
			
		}
		binary = binary.replaceAll(" ", "0");
		return PhotoMagic.tranform(pic, new LFSR(binary,point));
		
	}
	public static void main(String[] args) {
		Picture p = new Picture("mystery.png");
		String t = "banana";
		t = t.replaceAll("a", " ");
		System.out.println(t);
		 transform(p, "OPENSESAME", 58).show();
//		Picture n = transform(p,"open",6);
//		n.save("gitter.png");
//		n.show();
//		transform(n,"open",6).show();
	}

}
