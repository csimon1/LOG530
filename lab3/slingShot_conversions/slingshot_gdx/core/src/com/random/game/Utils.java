package com.random.game;

public class Utils {

	
	/*
	public static void load_image(String name, int colorkey){
	    //#fullname = os.path.join('data', name)
		String fullname = name;
		try {
			image = pygame.image.load(fullname);
		}
		catch(Exception e)  {
			System.out.println("Cannot load image:"+fullname);
			System.exit(0);
		}
		image = image.convert_alpha();
		if(colorkey != 0){
			if (colorkey == -1){
				colorkey = image.get_at((0,0));
			}
			image.set_colorkey(colorkey, RLEACCEL);
		}
		return image,image.get_rect();
	}
	*/
	
	public static float radians(int degree){
		return (float) (Math.PI / 180 * degree);
	}
	
	public static Pos get_intersect(Pos center, float r, Pos pos1, Pos pos2){
		//delete the tmp query ? LOL !
		final float dx = pos2.x - pos1.x;
		final float dy = pos2.y - pos1.y;
		final float px = pos1.x;
		final float py = pos1.y;
		final float cx = center.x;
		final float cy = center.y;
		final float a = dx*dx + dy*dy;
		final float b = 2 * (dx * px - dx * cx + dy * py - dy * cy);
		final float c = -2 * cx * px -2 * cy * py + px*px + py*py + cx*cx + cy*cy - r*r;
		final float D = b*b - 4 * a * c;

		if (D < 0){
			return new Pos(4000.0f, 3000.0f);
		}
		final double tmpSD = Math.sqrt(D);
		
		float alpha = (float) ((-b + tmpSD  ) / (2 * a));
		if (alpha > 1){
			alpha = (float) ((-b - tmpSD ) / (2 * a));
		}
		alpha = alpha - 0.05f;
		return new Pos(px + alpha * dx, py + alpha * dy);
	}
}
