package dmcigd.levels.faerie;

import java.net.URL;

import dmcigd.core.room.Room;

import dmcigd.core.objects.regions.*;
import dmcigd.levels.faerie.mobs.*;

public class Three extends Room implements Runnable {
	
	public Three(URL codeBase) {
		super(codeBase, "faerie", "Three", "foresty");
	}

	public void initializeRoom() {
		RisingPlatform risingPlatform = new RisingPlatform(getSolidObjects());
		addSolidObject(risingPlatform);
		addSolidObject(new DestroyRegion(risingPlatform, getSolidObjects()));
		
		//Wave 15
		addRegion(new ShieldChargerWaveTrigger(40 * 32, new String[] {
				"    m     m",
				"   mm    mm",
				"  mmm   mmm",
				" mmmm  mmmm",
				"mmmmmcmmmmm"
		}, this));
		
		//Wave 14
		addRegion(new ShieldChargerWaveTrigger(60 * 32, new String[] {
				"       m m ",
				"       m m ",
				"  m    m m ",
				" mmm   m m ",
				"mmmmmc_m_m "
		}, this));
		
		//Wave 13
		addRegion(new ShieldChargerWaveTrigger(80 * 32, new String[] {
				"         m ",
				"        mm ",
				"        mm ",
				"m       mm ",
				"m____c_mmm_"
		}, this));
		
		//Wave 12
		addRegion(new ShieldChargerWaveTrigger(100 * 32, new String[] {
				"       m  m",
				"       m  m",
				"m      m  m",
				"m      m  m",
				"m___mc_m__m"
		}, this));
		
		//Wave 11
		addRegion(new ShieldChargerWaveTrigger(120 * 32, new String[] {
				"          m",
				" m        m",
				" m  m     m",
				" m  m     m",
				"_mm_mc____m"
		}, this));
		
		//Wave 10
		addRegion(new ShieldChargerWaveTrigger(140 * 32, new String[] {
				" m m   m m ",
				" m m   m m ",
				"_m_m_c_m_m_"
		}, this));
		
		//Wave 9
		addRegion(new ShieldChargerWaveTrigger(160 * 32, new String[] {
				"         m ",
				" m       m ",
				" m     m m ",
				"_m_m_c_m_m_"
		}, this));
		
		//Wave 8
		addRegion(new ShieldChargerWaveTrigger(180 * 32, new String[] {
				"m          ",
				"mm         ",
				"mmm        ",
				"mmmm_c_____"
		}, this));
		
		//Wave 7
		addRegion(new ShieldChargerWaveTrigger(200 * 32, new String[] {
				"         m ",
				"         m ",
				"         m ",
				"_m___c___m_"
		}, this));
		
		//Wave 6
		addRegion(new ShieldChargerWaveTrigger(220 * 32, new String[] {
				" m         ",
				" m         ",
				"_m___c_m___"
		}, this));
		
		//Wave 5
		addRegion(new ShieldChargerWaveTrigger(239 * 32, new String[] {
				"        m  ",
				"_m___c__m__"
		}, this));
		
		//Wave 4
		addRegion(new ShieldChargerWaveTrigger(254 * 32, new String[] {
				" m         ",
				"_m___c_____"
		}, this));
		
		//Wave 3
		addRegion(new ShieldChargerWaveTrigger(269 * 32, new String[] {
				"_m___c__m__"
		}, this));
		
		//Wave 2
		addRegion(new ShieldChargerWaveTrigger(284 * 32, new String[] {
				"_m_m_c_____"
		}, this));
		
		//Wave 1
		addRegion(new ShieldChargerWaveTrigger(297 * 32, new String[] {
				"           ",
				"           ",
				"_m___c_____"
		}, this));
		
		addRegion(new RoomWarp(40 * 32, 8 * 32, 20 * 32, 32, "game.MainMenu"));
	}
}
