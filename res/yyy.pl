#!/usr/bin/perl -w

use Time::HiRes qw(usleep nanosleep);

opendir(DIR,"perl/");
@tribes= grep { $_ ne '.' && $_ ne '..' } readdir(DIR);
closedir(DIR);
foreach(@tribes){
	$tribe = $_;
	#print $tribe."\n";
	$tribefolder = "perl/".$tribe;
	print "------------------\n";
	print $tribefolder;
	print "\n------------------\n";
	if(-e "json/".$tribe){
		opendir(DIR,$tribefolder);
		@demons = grep { $_ ne '.' && $_ ne '..' } readdir(DIR);
		closedir(DIR);
		foreach(@demons){
			$demon = $_;
			$demonfile = $tribefolder."/".$demon."\n";
			print "---".$demonfile;
			open(FILE1,$demonfile);
			open(FILE2,'>'."json/".$tribe."/".$demon."on");
			print FILE2 "{\n";
			while($line=<FILE1>){
				if($line !~ /registerDemon\(\{/){
					if($line !~ /\}\)\;/){
						if($line !~ /\/\/*/){
							print FILE2 $line;
						}
					}
				}
			}
			print FILE2 "}\n";
			close FILE1;
			close FILE2;
		}
	}else{
		print "  MAKING DIRECTORY\n";
		mkdir "json/".$tribe;
	}
	print "\n";
}