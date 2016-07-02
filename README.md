# terraincontrolgui
A Java based GUI for the Terrain Control Plugin for Minecraft.

Clone repository into a folder on your computer and run 'mvn clean install'.

This is a Java coded application, it should work on Windows, Linux and Mac OS. I cannot test on the last one tough 
(and I do not want to either).

I will not be building the application for you until I am at a version where it makes sense to do so, since this application is not
in a proper release stage yet. If you do not know how maven works, then bad luck.

Do not fucking redistribute your modifications of this program. The only reason why the code is on github is if you are interested
at looking at the code (or are paranoid). It is not a free license for you to do whatever you want with the code. 

Do not sell, redistribute or claim this software as your own.
No Warranties are given, your computer explodes or whatever due to the software I do
not care.

Software is provided AS IS. No Guarantees are made.
I do not claim to be a great programmer. I am not very interested in feedback. Cannot deal with that kindly go to the woods 
and cry me a river.

Just tell me what works and what does not.


"But muh TCEE"

That is not made in Java and is not cross plattform in any way. Maybe with Wine but who the fuck wants to do that?
My software is made in JAVA, bar some quirks. It will work on any plattform that supports Java.
Whoever writes in a language that is very difficult to port to other operating systems, or outright does not support more operating systems is a casual lazybone.

## What can it do so far?

*Load the paths for the TerrainControl Folder, and The GlobalBiomes folder, The WorldObjects folder, and the entirety of the
TerrainControl.ini

*Change the TerrainControl.ini settings, and save them back into the file.

## What is planned?

FromImage Palette (Brings up the hexcolors and associates them with a biomename, and also displays the color on the screen).
Editing of all the config files. Even the bo3 objects (except the material positions. That is a bit complicated. But you will be able 
to change the general stats of a bo3 file).

SLIDERS! WE FUCKING LOVE SLIDERS FOR NUMBERS DON'T WE? 
TL;DR Gui assistance for the config files so you do not have to write so damn much.

Autobackupp feature (tell it the number of folders you want to create, and it will take a backupp of the current state of all settings
you have loaded/modified into the program so far every 5 minutes.
When it reaches your number, it will delete the oldest backupp.

bo3 Image support. Will show one image for each bo3.
(Software will come with pre-made image files for typical bo3 files found on the internet, such as Biome Bundle).

Other features that I have no idea but will probably appear as I recnogize things that could be done easier if you had a GUI for it.

