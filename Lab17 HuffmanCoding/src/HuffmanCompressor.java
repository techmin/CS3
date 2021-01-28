import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HuffmanCompressor 
{
	public  void compress(String fileName)
	{
		Scanner rec =null;
		String fn =fileName.substring(0, fileName.indexOf('.'));
		
		PrintWriter write = null;
		
		try
		{
			rec = new Scanner(new File(fileName));
			write = new PrintWriter(fn+".short");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
			e.getStackTrace();
		}
		int[] count = new int[256];
		BitOutputStream bos = new BitOutputStream(fn+".short");

		System.out.println(fileName.toString());
		JOH : while(rec.hasNext())
		{
			/*
			 * going through the char to find the frequency 
			 */
			String line = rec.nextLine();
			char[] brockenDWN = line.toCharArray();
			System.out.println("this far");
			for(char c : brockenDWN)
			{
				count[c] +=1;
			}
			HuffmanTree encodeTree = new HuffmanTree(count);
			encodeTree.write(fileName);
			
//			System.out.println("the binarty " +encodeTree.getFile().toString());
		String codes = encodeTree.toString();
			char[] bits = codes.toCharArray();
			for(char c :bits)
			{
				if(c =='0')
					bos.writeBit(0);
				else
					bos.writeBit(1);
			}
			
		}
	}
		
		public void encode(String codeFile,String fileName)
		{
			HuffmanTree ht = new HuffmanTree(codeFile);
			Scanner rec =null;
			try
			{
				rec =new Scanner(new File(fileName));
			}
			catch(FileNotFoundException e)
			{
				e.getMessage();
			}
			BitInputStream bitIn = new BitInputStream(codeFile);
			ht.decode(bitIn, codeFile);
			
			ht.write(fileName);
			
			
			
		}
		
		
	
}
	


