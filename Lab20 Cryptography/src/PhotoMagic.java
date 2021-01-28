import java.awt.Color;

import org.w3c.dom.ls.LSParserFilter;

public class PhotoMagic 
{
	public static Picture tranform(Picture pic , LFSR lfsr)
	{
		int width = pic.width();
		int height = pic.height();
		for(int w=0; w<width; w++)
		{
			for(int h =0; h<height;h++)
			{
				Color c = pic.get(w, h);
				int r = c.getRed() ^ lfsr.generate(8);
				int b = c.getBlue()^lfsr.generate(8);
				int g = c.getGreen() ^ lfsr.generate(8);
				pic.set(w, h, new Color(r,g,b));
				    
			}
		}
		return pic;
		
	}
	
	public static void main(String[] args) {
		Picture p = new Picture("pipe.png");	
		Picture dif = null;
		 dif = tranform(p, new LFSR("01101000010100010000",16));
		 dif.save("gitter.png");
//		 p.show();
		 dif.show();
		tranform(dif, new LFSR("01101000010100010000",16)).save("try.png");
		new Picture("try.png").show();
		
	}

}
