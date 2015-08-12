package com.random.game.slingshot;

public class Game {
	public void __init__(){
		pygame.display.init();
		
		//#self.clock = pygame.time.Clock();
		
		self.screen = pygame.display.set_mode((800, 600));
		icon, rect = load_image("data/icon64x64.png", (0,0,0));
		pygame.display.set_icon(icon);
		pygame.display.set_caption('Slingshot');
		
		Settings.particle_image10, Settings.particle_image10_rect = load_image("data/explosion-10.png", (0,0,0));
		Settings.particle_image5, Settings.particle_image5_rect = load_image("data/explosion-5.png", (0,0,0));
		
		Settings.menu_background, Settings.menu_rect = load_image("data/menu.png", (0,0,0));
		Settings.box, rect = load_image("data/box.png", (0,0,0));
		Settings.tick, rect = load_image("data/tick.png", (0,0,0));
		Settings.tick_inactive, rect = load_image("data/tick_inactive.png", (0,0,0));
		
		self.trail_screen = pygame.Surface(self.screen.get_size());
		self.trail_screen = self.trail_screen.convert();
		self.trail_screen.set_colorkey((0,0,0));
		self.trail_screen.set_alpha(125);
		
		self.planet_screen = pygame.Surface(self.screen.get_size());
		self.planet_screen = self.trail_screen.convert();
		self.planet_screen.set_colorkey((0,0,0));
		
		self.dim_screen = pygame.Surface(self.screen.get_size());
		self.dim_screen.set_alpha(175);
		self.dim_screen = self.dim_screen.convert_alpha();
		//#self.dim_screen.fill((0,0,0));
		
		self.background, r = load_image("data/backdrop.png");
		
		self.players = (Dummy(), Player(1), Player(2));
		self.playersprites = pygame.sprite.RenderPlain((self.players[1], self.players[2]));
		self.missile = Missile(self.trail_screen);
		self.missilesprite = pygame.sprite.RenderPlain((self.missile));
		
		self.load_settings();
		
		//#self.fixed_power = Settings.FIXED_POWER;
		//#self.bounce = Settings.BOUNCE;
		//#self.invisible = Settings.INVISIBLE;
		//#self.random = Settings.RANDOM;
		//#self.timeout = Settings.MAX_FLIGHT;
		
		//#self.max_planets = Settings.MAX_PLANETS;
		//#self.max_rounds = Settings.MAX_ROUNDS;
		
		self.main_menu = Menu("Menu");
		self.main_menu.add("Back to game");
		self.main_menu.add("New game");
		self.main_menu.add("Settings");
		self.main_menu.add("Help");
		self.main_menu.add("Quit");
		
		self.confirm_menu1 = Confirm("Starting a new game", "will apply new settings", "and reset the scores");
		self.confirm_menu1.add("Yes");
		self.confirm_menu1.add("No");
		
		self.confirm_menu2 = Confirm("Starting a new game", "will reset the scores");
		self.confirm_menu2.add("Yes");
		self.confirm_menu2.add("No");
		
		self.apply_menu = Confirm("This will start a", "new game and reset", "the scores");
		self.apply_menu.add("Yes");
		self.apply_menu.add("No");
		
		self.settings_menu = Menu("Settings");
		self.settings_menu.add("Back");
		self.settings_menu.add("Game style");
		self.settings_menu.add("Game options");
		self.settings_menu.add("Apply settings");
		self.settings_menu.add("Graphics");
		
		
		self.style_menu = Menu("Game style");
		self.style_menu.add("Back");
		self.style_menu.addoption("Random", self.random);
		self.style_menu.addoption("Fixed power", self.fixed_power, not self.random);
		self.style_menu.addoption("Bounce", self.bounce, not self.random);
		self.style_menu.addoption("Invisible planets", self.invisible, not self.random);
		
		self.mode_menu = Menu("Game options");
		self.mode_menu.add("Back");
		self.mode_menu.add("Max number of planets");
		self.mode_menu.add("Number of rounds");
		self.mode_menu.add("Shot timeout");
		
		self.timeout_menu = Numeric("Shot timeout", self.timeout, 250, 2000, 500);
		
		self.graphics_menu = Menu("Graphics");
		self.graphics_menu.add("Particles");
		
		self.planet_menu = Numeric("Maximum number of planets", self.max_planets, 1, 8, 2);
		
		self.particles_menu = Menu("Particle");
		self.particles_menu.add("Back");
		self.particles_menu.add("On");
		self.particles_menu.add("Off");
		
		self.rounds_menu = Numeric("Number of rounds", self.max_rounds, 5, 100, 0, "Infinite");
		
		self.help_menu = Help();
		
		self.welcome_menu = Welcome();
		
		self.menu = self.welcome_menu;
		
		self.q = False;
		
		self.message = "";
		self.score_message = "";
		
		self.started = False;
		
		self.game_init();
	}
	
	public void game_init(){
		self.new_game();
		self.round_init();
		self.bounce_count = 255;
		self.bounce_count_inc = 7;
	}
		
	public void settings_changed(){
		result = false;
		
		if (Settings.MAX_PLANETS != self.max_planets){
			result = true;
		}
		if (Settings.MAX_FLIGHT != self.timeout){
			result = true;
		}
		if (Settings.BOUNCE != self.bounce){
			result = true;
		}
		if (Settings.INVISIBLE != self.invisible){
			result = true;
		}
		if (Settings.FIXED_POWER != self.fixed_power){
			result = true;
		}
		if (Settings.MAX_ROUNDS != self.max_rounds){
			result = true;
		}
		if (Settings.RANDOM != self.random){
			result = true;
		}
		
		return result;
	}
				
	public void new_game(){
		Settings.MAX_PLANETS = self.max_planets;
		Settings.BOUNCE = self.bounce;
		Settings.INVISIBLE = self.invisible;
		Settings.FIXED_POWER = self.fixed_power;
		Settings.MAX_ROUNDS = self.max_rounds;
		Settings.RANDOM = self.random;
		Settings.MAX_FLIGHT = self.timeout;
		
		self.player = randint(1,2);
		
		self.round = 0;
		self.players[1].reset_score();
		self.players[2].reset_score();	
		self.game_over = false;
	}
		
	public void round_init(){
		pygame.key.set_repeat(Settings.KEY_DELAY, Settings.KEY_REPEAT);
		
		if (self.round == Settings.MAX_ROUNDS)
			self.new_game();
			
		if (Settings.RANDOM){
			Settings.BOUNCE = (randint(0,1) == 1);
			Settings.FIXED_POWER = (randint(0,1) == 1);
			Settings.INVISIBLE = (randint(0,1) == 1);
		}
		
		self.round_over = false;
		
		self.players[1].init();
		self.players[2].init();
		
		self.missile.flight = 0;
		
		self.firing = 0;
		self.particlesystem = pygame.sprite.RenderPlain();
		
		self.planetsprites = self.create_planets();
		
		self.trail_screen.fill((0, 0, 0));
		
		self.round += 1;
		
		if(self.players[1].score < self.players[2].score)
			self.player = 1;
		else if(self.players[2].score < self.players[1].score)
			self.player = 2;
		
		self.show_round = 100;
		if(Settings.INVISIBLE)
			self.show_planets = 100;
		else
			self.show_planets = 0;
	}
		
	public void toggle_menu(){
		if(self.menu == None)
			self.menu = self.main_menu;
		else if(self.menu == self.main_menu)
			self.menu = None;
		else if(self.menu == self.particles_menu)
			self.menu = self.graphics_menu;
		else if(self.menu == self.rounds_menu)
			self.menu = self.mode_menu;
		else if(self.menu == self.planet_menu)
			self.menu = self.mode_menu;
		else if(self.menu == self.mode_menu)
			self.menu = self.settings_menu;
		else if(self.menu == self.style_menu)
			self.menu = self.settings_menu;
		else if(self.menu == self.timeout_menu)
			self.menu = self.mode_menu;
		else if(self.menu == self.rounds_menu)
			self.menu = self.settings_menu;
		else
			self.menu = self.main_menu;
			
//#		if(self.menu == self.main_menu)
//#			self.menu.reset();
		if(self.menu != None)
			self.menu.reset();
			
		if(self.menu == None){
			pygame.key.set_repeat(Settings.KEY_DELAY, Settings.KEY_REPEAT);
			self.started = true;
		}
		else{
			pygame.key.set_repeat();
		}
	}
		
	public void  create_particlesystem(pos, n, size){
		if(Settings.PARTICLES){
			if(Settings.BOUNCE){
				nn = n / 2;
			}
			else{
				nn = n;
			}
			for(i in range(nn)){
				self.particlesystem.add(Particle(pos, size));
			}
		}
	}
		
	public void  create_planets(){
		result = pygame.sprite.RenderPlain();
		n = randint(2, Settings.MAX_PLANETS);
		for(i in range(n)){
			result.add(Planet(result, self.background));
		}
		return result;
	}
	
	public void change_angle(a){
		self.players[self.player].change_angle(a);
	}
	
	public void change_power(p){
		self.players[self.player].change_power(p);
	}
	
	public void fire(){
		if (self.round_over){
			self.round_init();
		}
		else if (! self.firing){
			self.missile.launch(self.players[self.player]);
			self.players[self.player].attempts += 1;
			self.last = self.player;
			self.player = 0;
			self.firing = 1;
			pygame.key.set_repeat();
		}
	}
		
	public void draw_zoom(){
		normal_screen = pygame.Surface((800, 600));
		normal_screen.set_colorkey((0,0,0));
		normal_screen.convert_alpha();
		self.playersprites.draw(normal_screen);
		if (! Settings.INVISIBLE){
			self.planetsprites.draw(normal_screen);
		}
		
		zoom_screen = pygame.Surface((600, 450));
		zoom_screen.set_colorkey((0,0,0));
		zoom_screen.convert_alpha();
		
		background = pygame.transform.scale(self.background, (600,450));
		zoom_screen.blit(self.background, (0,0));
		normal_screen = pygame.transform.scale(normal_screen, (200,150));
		zoom_screen.blit(normal_screen, (200,150));
		
		missilesprite = self.missile.get_image();
		missilesprite = pygame.transform.scale(missilesprite, (missilesprite.get_size()[0] / 3, missilesprite.get_size()[1] / 3))
		pos = self.missile.get_pos();
		pos = (200 + pos[0] / 4 - missilesprite.get_width() / 2, 150 + pos[1] / 4- missilesprite.get_height() / 2);
		zoom_screen.blit(missilesprite, pos);
		
		pygame.draw.rect(zoom_screen, (255,255,255), pygame.Rect(0, 0, 600, 450), 1);
		pygame.draw.rect(zoom_screen, (150,150,150), pygame.Rect(200, 150, 200, 150), 1);
		self.screen.blit(self.dim_screen, (0,0));
		self.screen.blit(zoom_screen, (100, 75));
	}
				
	public void draw(){
		self.screen.blit(self.background, (0, 0));
		
		if (Settings.BOUNCE){
			pygame.draw.rect(self.screen, (self.bounce_count, 0, 0), pygame.Rect(0, 0, 800, 600), 1);
		}
		
		show_planets = false;
		if (not Settings.INVISIBLE){
			show_planets = true;
		}
		else{
			if (self.round_over){
				if (self.show_planets > 0){
					for (p in self.planetsprites){
						p.fade(self.show_planets);
					}
					self.planetsprites.draw(self.screen);
					self.show_planets -= 1;
				}
				else{
					show_planets = true;
				}
			}
		}
		if (show_planets){
			self.planetsprites.draw(self.screen);
		}
		self.screen.blit(self.trail_screen, (0,0));
		self.playersprites.draw(self.screen);
//#		self.players[1].draw(self.screen);
//#		self.players[2].draw(self.screen);
//#		print self.particlesystem;
		if (Settings.PARTICLES){
			self.particlesystem.draw(self.screen);
		}
		if (self.firing){
			if (self.missile.visible()){
				self.missilesprite.draw(self.screen);
			}
		}
//#		print self.planetsprites;
		if (self.firing){
			if (! self.missile.visible()){
				self.draw_zoom();
			}
		}
		self.players[1].draw_status(self.screen);
		self.players[2].draw_status(self.screen);
		if (! self.round_over){
			self.players[self.player].draw_info(self.screen);
			self.players[self.player].draw_line(self.screen);
		}
		else{
			if (self.show_round > 30){
				txt = Settings.round_font.render("Game Over", 1, (255,255,255));
				tmp = pygame.Surface(txt.get_size());
				tmp = tmp.convert_alpha()
				tmp.blit(txt, (0,0))
				tmp = tmp.convert()
				tmp.set_alpha(2 * self.show_round - 60)
				tmp.set_colorkey((0,0,0))
				tmp = tmp.convert_alpha()
				rect = tmp.get_rect()
				s = (100 - self.show_round) * rect.h / 15
				tmp = pygame.transform.scale(tmp, (rect.w / rect.h * s, s ))
				rect = tmp.get_rect()
				rect.center = (399,299)
				self.screen.blit(tmp, rect.topleft)
				self.show_round /= 1.04
			}
			else if (self.show_planets <= 0){
				dim = pygame.Surface(self.end_round_msg.get_size())
				dim.set_alpha(175)
				dim = dim.convert_alpha()
				
				rect = self.end_round_msg.get_rect()
				rect.center = (399,299)
				
				self.screen.blit(dim, rect.topleft)
				self.screen.blit(self.end_round_msg, rect.topleft)
			}
		}
		if (self.firing){
			self.missile.draw_status(self.screen)
		}
		else if (self.started){
			if (Settings.MAX_ROUNDS > 0){
				txt = Settings.font.render("Round %d of %d" %(self.round, Settings.MAX_ROUNDS), 1, (255,255,255))
			}
			else{
				txt = Settings.font.render("Round %d" %(self.round), 1, (255,255,255))
			}
			rect = txt.get_rect()
			rect.midbottom = (399, 594)
			self.screen.blit(txt, rect.topleft)
		}
		if (self.started and not self.game_over){
			if (self.show_round > 30){
				txt = Settings.round_font.render("Round %d" %(self.round), 1, (255,255,255))
				tmp = pygame.Surface(txt.get_size())
				tmp = tmp.convert_alpha()
				tmp.blit(txt, (0,0))
				tmp = tmp.convert()
				tmp.set_alpha(2 * self.show_round - 60)
				tmp.set_colorkey((0,0,0))
				tmp = tmp.convert_alpha()
				rect = tmp.get_rect()
				s = (100 - self.show_round) * rect.h / 25
				int1 = int(round(rect.w / rect.h * s))
				int2 = int(s)
				tmp = pygame.transform.scale(tmp, (int1, int2 ))
				rect = tmp.get_rect()
				rect.center = (399,299)
				self.screen.blit(tmp, rect.topleft)
				self.show_round /= 1.04
			}
		}
		if (! self.menu == None){
			if (self.menu.dim){
				self.screen.blit(self.dim_screen, (0,0))
			}
			img = self.menu.draw()
			rect = img.get_rect()
			rect.center = (399,299)
			self.screen.blit(img, rect.topleft)
		}	
		pygame.display.flip()
	}
			
	public void update_particles(){
		if (Settings.PARTICLES){
			for (p in self.particlesystem){
	//#			print p.get_pos();
				if (p.update(self.planetsprites) == 0 or p.flight < 0){
					if (p.flight >= 0 and p.in_range()){
						if (p.get_size() == 10){
							self.create_particlesystem(p.get_impact_pos(), Settings.n_PARTICLES_5, 5);
						}
					}
	//#				print "removing: ", p.get_pos();
					self.particlesystem.remove(p);
				}
				if (p.flight > Settings.MAX_FLIGHT){
					self.particlesystem.remove(p);
				}
			}
		}
	}
	
	public void end_shot(){
		pygame.event.clear();
		self.player = 3 - self.last;
		if (self.menu == None){
			pygame.key.set_repeat(Settings.KEY_DELAY,Settings.KEY_REPEAT);
		}
		self.firing = 0;
	}
		
	public void menu_action(){
		c = self.menu.get_choice();
		if (self.menu == self.planet_menu){
			if (c >= 0){
				self.max_planets = c;
				self.toggle_menu();
			}
		}
		if (self.menu == self.rounds_menu){
			if (c >= 0){
				self.max_rounds = c;
				self.toggle_menu();
			}
		}
		if (self.menu == self.timeout_menu){
			if (c >= 0){
				self.timeout = c;
				self.toggle_menu();
			}
		}
		if (c == "Quit"){
			self.q = true;
		}
		else if (c == "Back"){
			self.toggle_menu();
		}
		else if (c == "Start"){
			self.started = true;
			self.menu = None;
		}
		else if (c == "Back to game"){
			self.toggle_menu();
		}
		else if (c == "Apply settings"){
			self.menu = self.apply_menu;
		}
		else if (c == "New game"){
			if (self.settings_changed()){
				self.menu = self.confirm_menu1;
			}
			else{
				self.menu = self.confirm_menu2;
			}
		}
		else if (c == "Number of rounds"){
			self.menu = self.rounds_menu;
		}
		else if (c == "Shot timeout"){
			self.menu = self.timeout_menu;
		}
		else if (c == "Game style"){
			self.menu = self.style_menu;
		}
		else if (c == "Random"){
			self.random = not self.random;
			self.style_menu.change_active("Bounce", not self.random);
			self.style_menu.change_active("Invisible planets", not self.random);
			self.style_menu.change_active("Fixed power", not self.random);
		}
		else if (c == "Help"){
			self.menu = self.help_menu;
		}
		else if (c == "Yes"){
			self.menu = None;
			self.save_settings()
			self.game_init();
		}
		else if (c == "No"){
			self.toggle_menu();
		}
		else if (c == "Settings"){
			self.menu = self.settings_menu;
		}
		else if (c == "Game options"){
			self.menu = self.mode_menu;
		}
		else if (c == "Graphics"){
			self.menu = self.graphics_menu;
		}
		else if (c == "Shot timeout"){
			self.menu = self.timeout_menu;
		}
		else if (c == "Fixed power"){
			self.fixed_power = not self.fixed_power;
		}
		else if (c == "Bounce"){
			self.bounce = not self.bounce;
		}
		else if (c == "Invisible planets"){
			self.invisible = not self.invisible;
		}
		else if (c == "Max number of planets"){
			self.menu = self.planet_menu;
		}
		else if (c == "Particles"){
			self.menu = self.particles_menu;
		}
		else if (c == "On"){
			Settings.PARTICLES = true;
			self.toggle_menu()
		}
		else if (c == "Off"){
			Settings.PARTICLES = false;
			self.toggle_menu();
		}
	}
		
	public void update(){
		self.update_particles();
		if (self.firing){
			self.firing = self.missile.update(self.planetsprites, self.players);
			if (self.missile.flight < 0 && ! self.missile.visible()){
				self.firing = 0
			}
			if (! self.firing){
				if (self.missile.visible()){
					self.create_particlesystem(self.missile.get_impact_pos(), Settings.n_PARTICLES_10, 10);
				}
				self.end_shot();
			}
		}
		if (! self.menu == None){
			self.menu_action();
		}
		if (self.players[1].shot || self.players[2].shot){
			if (self.players[1].shot){
				self.players[1].update_explosion();
			}
			else{
				self.players[2].update_explosion();
			}
			pygame.key.set_repeat();
			if (! self.round_over){
				self.end_round();
			}
		}
		if (self.menu == None){
			self.started = True;
		}
		self.bounce_count += self.bounce_count_inc;
		if (self.bounce_count > 255 || self.bounce_count < 125){
			self.bounce_count_inc *= -1;
			self.bounce_count += 2 * self.bounce_count_inc;
		}
	}
				
	public void end_round(){
		self.round_over = true;
		
		if (self.round == Settings.MAX_ROUNDS){
			offset1 = 50;
		}
		else{
			offset1 = 0;
		}
		
		power_penalty = self.missile.get_score();
		for (i in range(1, 3)){
			if (self.players[i].shot){
				if (self.player == 3 - i){
					message = "Player %d killed self" %(i);
					score = Settings.SELFHIT;
					score_message = "%d deducted from score" %(score);
					self.players[i].add_score(-score);
					killed_self = true;
				}
				else{
					message = "Player %d killed player %d" %((3 - i), i);
					if self.players[3 - i].attempts == 1){
						bonus = Settings.QUICKSCORE1;
					}
					else if self.players[3 - i].attempts == 2){
						bonus = Settings.QUICKSCORE2;
					}
					else if self.players[3 - i].attempts == 3){
						bonus = Settings.QUICKSCORE3;
					}
					else{
						bonus = 0;
					}
					killed_self = False;
					score = power_penalty + bonus + Settings.HITSCORE;
					score_message = "%d added to score" %(score);
					self.players[3 - i].add_score(score);
				}
				
				if (! killed_self){
					offset = 40;
				}
				else{
					offset = 0;
				}
					
				if (self.round == Settings.MAX_ROUNDS){
					offset2 = 40;
				}
				else
					offset2 = 0;
									
				self.end_round_msg = pygame.Surface((450,190 + offset + offset1 + offset2));
				self.end_round_msg.set_colorkey((0,0,0));
				self.end_round_msg.fill((0,0,0));
				
				if (self.round == Settings.MAX_ROUNDS){
					msg = Settings.menu_font.render("Game over", 1, (255,255,255));
					rect = msg.get_rect();
					rect.midtop = (224, 28);
					self.end_round_msg.blit(msg, rect.topleft);
				}
				msg = Settings.font.render(message, 1, (255,255,255));
				rect = msg.get_rect();
				rect.midtop = (224,28 + offset1);
				self.end_round_msg.blit(msg, rect.topleft);
				
				if (! killed_self){
					msg = Settings.font.render("Hit opponent:", 1, (255,255,255));
				}
				else{
					msg = Settings.font.render("Hit self:", 1, (255,255,255));
				}
				rect = msg.get_rect();
				rect.topleft = (50,65 + offset1);
				self.end_round_msg.blit(msg, rect.topleft);
				
				if (! killed_self){
					msg = Settings.font.render("%d" %(Settings.HITSCORE), 1, (255,255,255));
				}
				else{
					msg = Settings.font.render("%d" %(Settings.SELFHIT), 1, (255,255,255));
				}
				rect = msg.get_rect();
				rect.topright = (399,65 + offset1);
				self.end_round_msg.blit(msg, rect.topleft);
				
				if (! killed_self){
					msg = Settings.font.render("Quickhit bonus:", 1, (255,255,255));
					rect = msg.get_rect();
					rect.topleft = (50,85 + offset1);
					self.end_round_msg.blit(msg, rect.topleft);
					
					msg = Settings.font.render("%d" %(bonus), 1, (255,255,255));
					rect = msg.get_rect();
					rect.topright = (399,85 + offset1);
					self.end_round_msg.blit(msg, rect.topleft);
				
					msg = Settings.font.render("Power penalty:", 1, (255,255,255));
					rect = msg.get_rect();
					rect.topleft = (50,105 + offset1);
					self.end_round_msg.blit(msg, rect.topleft);
				
					msg = Settings.font.render("%d" %(power_penalty), 1, (255,255,255));
					rect = msg.get_rect();
					rect.topright = (399,105 + offset1);
					self.end_round_msg.blit(msg, rect.topleft);
				}
					
				msg = Settings.font.render(score_message, 1, (255,255,255));
				rect = msg.get_rect();
				rect.midtop = (224, 100 + offset + offset1);
				self.end_round_msg.blit(msg, rect.topleft);
				
				if (self.round == Settings.MAX_ROUNDS){
					self.show_round = 100;
					self.game_over = true;
					if (self.players[1].score > self.players[2].score){
						winner = 1;
					}
					else if (self.players[2].score > self.players[1].score){
						winner = 2;
					}
					else{
						winner = 0;
					}
					Settings.font.set_bold(True);
					if (winner != 0){
						msg = Settings.font.render("Player %d has won the game" %(winner), 1, (255,255,255));
					}
					else{
						msg = Settings.font.render("The game has ended in a tie", 1, (255,255,255));
					}
					Settings.font.set_bold(false);
					rect = msg.get_rect();
					rect.midtop = (224, 140 + offset + offset1);
					self.end_round_msg.blit(msg, rect.topleft);
				}
				
				if (self.round < 10){
					msg = Settings.font.render("Press fire for a new round or escape for the menu", 1, (255,255,255));
				}
				else{
					msg = Settings.font.render("Press fire for a new game or escape for the menu", 1, (255,255,255));
				}
				rect = msg.get_rect();
				rect.midtop = (224, 140 + offset + offset1 + offset2);
				self.end_round_msg.blit(msg, rect.topleft);
				
				pygame.draw.rect(self.end_round_msg, (150,150,150), self.end_round_msg.get_rect(), 1);
			}
		}
	}
	
	public void run(){
		pygame.time.set_timer(TIMEREVENT, 1000 / Settings.FPS);
		pos1 = null;
		p = 10;
		a = 2;
		
		while (! self.q){
			//#self.clock.tick(Settings.FPS);
			//#			print clock.get_fps();
				event = pygame.event.wait();
				
				if (event.type == TIMEREVENT){
					self.update();
					self.draw();
				}

			//#for event in pygame.event.get():
				//#adding ctrl for mouse [Lighta]
				if (event.type == pygame.MOUSEBUTTONDOWN){
					#sys.stdout.write("Event get="+str(event)+ '\n');
					pos1 = pygame.mouse.get_pos();
					sys.stdout.write("Event pos bd="+str(pos1)+ '\n');
					
					if (event.button == MouseButtons.RIGHT){
						self.toggle_menu();
					}
					
					if (self.menu == null){
						p = 10;
						a = 2;
						
						if (! self.round_over){
							if (event.button == MouseButtons.WHEEL_UP){
								self.change_power(p);
							}
							else if (event.button == MouseButtons.WHEEL_DOWN){
								self.change_power(-p);
							}
							//#else (if event.key == K_LEFT)
							//#	self.change_angle(-a);
							//#else (if event.key == K_RIGHT)
							//#	self.change_angle(a);
						}
					}
					else{
						if (event.button == MouseButtons.WHEEL_UP){
							self.menu.up();
						}
						else if (event.button == MouseButtons.WHEEL_DOWN){
							self.menu.down();
						}
						//#else if event.key == K_LEFT)
						//#	self.menu.left();
						//#elif event.key == K_RIGHT)
						//#	self.menu.right();
						else if (event.button == MouseButtons.LEFT){
							self.menu.select();
						}
					}
				}
				
				if (event.type == pygame.MOUSEBUTTONUP){
					if (event.button == MouseButtons.LEFT){
						pos1 = None;
						self.fire();
					}
				}
					
				if (event.type == pygame.MOUSEMOTION){
					if (pos1){
						pos2 = pygame.mouse.get_pos();
						p = 10;
						a = 2;
						if (self.player == 1){
							p *= -1;
							a *= -1;
						}

						//#sys.stdout.write("Event pos motion="+'\n')
						if( ((pos2[MouseButtons.HORZ]-pos1[MouseButtons.HORZ])/Settings.MOVE_GAP )){
							self.change_power(p);
							pos1 = pos2;
						}
						else if( ((pos1[MouseButtons.HORZ]-pos2[MouseButtons.HORZ])/Settings.MOVE_GAP )){
							self.change_power(-p);
							pos1 = pos2;
						}
						else if( ((pos2[MouseButtons.VERT]-pos1[MouseButtons.VERT])/Settings.MOVE_GAP )){
							self.change_angle(a);
							pos1 = pos2;
						}
						else if( ((pos1[MouseButtons.VERT]-pos2[MouseButtons.VERT])/Settings.MOVE_GAP )){
							self.change_angle(-a);
							pos1 = pos2;
						}
					}
				}


				if (event.type == QUIT){ 
					self.q = true;
				}
				else if (event.type == KEYDOWN){
					if (event.key == K_ESCAPE){
						self.toggle_menu();
					}
					if (self.menu == None){
						if (event.mod == KMOD_LCTRL || event.mod == 64 || event.mod == KMOD_RCTRL){
							p = 1;
							a = 0.25;
						}
						else if (event.mod == KMOD_LSHIFT || event.mod == 1 || event.mod == KMOD_RSHIFT){
							p = 25;
							a = 5;
						}
						else if (event.mod == KMOD_LALT || event.mod == 20480 || event.mod == KMOD_RALT){
							p = 0.2;
							a = 0.05;
						}
						else{
							p = 10;
							a = 2;
						}
						
						if (! self.round_over){
							if ( event.key == K_UP){
								self.change_power(p);
							}
							else if (event.key == K_DOWN){
								self.change_power(-p);
							}
							else if (event.key == K_LEFT){
								self.change_angle(-a);
							}
							else if (event.key == K_RIGHT){
								self.change_angle(a);
							}
						}
						if (event.key == 13 || event.key == 32){
							self.fire();
						}
					}
					else{
						if(event.key == K_UP){
							self.menu.up();
						}
						else if (event.key == K_DOWN){
							self.menu.down();
						}
						else if (event.key == K_LEFT){
							self.menu.left();
						}
						else if (event.key == K_RIGHT){
							self.menu.right();
						}
						else if (event.key == 13 || event.key == 32){
							self.menu.select();
						}
					}
				}
			//} for getevent
		}

		self.save_settings();
	}
	

	public void load_settings(){
		self.bounce = Settings.BOUNCE;
		self.fixed_power = Settings.FIXED_POWER;
		self.invisible = Settings.INVISIBLE;
		self.random = Settings.RANDOM;
		self.max_planets = Settings.MAX_PLANETS;
		self.timeout = Settings.MAX_FLIGHT;
		self.max_rounds = Settings.MAX_ROUNDS;
		
		if (android)
			path = "/settings";
		else
			path = os.path.expanduser("~") + "/.slingshot/settings";
		
		if (os.path.exists(path)){
			f=open(path, 'r');
			lines = f.readlines();
			for(l in lines){
				tokens = l.split();
				if (tokens[0] == "Bounce:"){
					if (tokens[1] == "1"){
						self.bounce = true;
					}
				}
				if (tokens[0] == "Fixed_Power:"){
					if (tokens[1] == "1"){
						self.fixed_power = true;
					}
				}
				else if (tokens[0] == "Particles:"){
					if (tokens[1] == "1"){
						Settings.PARTICLES = true;
					}
				}
				else if (tokens[0] == "Random:"){
					if (tokens[1] == "1"){
						self.random = true;
					}
				}
				else if (tokens[0] == "Invisible:"){
					if (tokens[1] == "1"){
						self.invisible = true;
					}
				}
				else if (tokens[0] == "Max_Planets:"){
					self.max_planets = int(tokens[1]);
				}
				else if (tokens[0] == "Timeout:"){
					self.timeout = int(tokens[1]);
				}
				else if (tokens[0] == "Rounds:"){
					self.max_rounds = int(tokens[1]);
				}
			}
			f.close();
		}
	}

	public void save_settings(){
		if(! android){
			path = os.path.expanduser("~") + "/.slingshot";
			if( ! os.path.exists(path)){
				os.mkdir(path);
			}
		}
		path += "/settings";
		f = file(path, 'wt');
		if (self.bounce)
			f.write("Bounce: 1\n");
		else
			f.write("Bounce: 0\n");
		if (self.fixed_power)
			f.write("Fixed_Power: 1\n");
		else
			f.write("Fixed_Power: 0\n");
		if (self.invisible)
			f.write("Invisible: 1\n");
		else
			f.write("Invisible: 0\n");
		if (self.random)
			f.write("Random: 1\n");
		else
			f.write("Random: 0\n");
		if (Settings.PARTICLES)
			f.write("Particles: 1\n");
		else
			f.write("Particles: 0\n");
			
		f.write("Max_Planets: %d\n" %(self.max_planets));
		f.write("Timeout: %d\n" %(self.timeout));
		f.write("Rounds: %d\n" %(self.max_rounds));
		f.close();
	}

	/*
	def main():
	    
		#sys.stdout = Blackhole()
		#sys.stderr = Blackhole()
		if android:
			pass
		else:
			path = os.path.expanduser("~") + "/.slingshot"
			if not os.path.exists(path):
				os.mkdir(path)
			path += "/logfile.txt"
		#	sys.stderr = open(path,"w")
		#	sys.stdout = sys.stderr
		game = Game()
		game.run()
	*/
}
