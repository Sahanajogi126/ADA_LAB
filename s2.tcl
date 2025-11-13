set ns [new Simulator]
set tracefile [open s3tr w]
$ns trace - all $ tracefile
set namfile [open s3.nam w]
$ns namtrace - all $namfile
proc finish {}{
global ns namfile tracefile
$ns flush-trace
close $namfile
close $tracefile
exec nam s3.nam &
exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]

set n7 [$ns node]
set n8 [$ns node]

$ns color 1 Blue
$ns color 1 Red
$n7 shape box
$n7 color Blue
$n8 shape hexagon
$n8 color Red
$ns duplex - link $n1 $n0 2Mb 10ms DropTail
$ns duplex - link $n1 $n0 2Mb 10ms DropTail
$ns duplex - link $n1 $n0 2Mb 10ms DropTail
$ns make _ lan "$n3 $n4 $n5 $n6 $n7 $n8" 512Kb40ms LL Queue / DropTail Mac/802_3
$ns duplex - link - op $n1 $n0 orient right down
$ns duplex - link - op $n1 $n0 orient right - up
$ns duplex - link - op $n1 $n0 orient right 
$ns queue - limit $n0 $n3 20
set tcp1 [new Agent / TCP / Vegas ]
$ns attach - agent $n1 $tcp1
set sink 1 [newAgent / TCPSink ]
$ns attach - agent $n7 $sink1
set ftp1 [new Application / FTP] 
$ftp1 attach - agent $tcp 1
$ns connect $tcp1 $sink1
$tcp1 set class _ 1
$tcp1 set packetsize _ 55
set tfile1 [open cwnd1.tr w]
$ tcp1 attach $tfile1
$ tcp1 trace cwnd_

set tcp2 [new Agent / TCP / Reno]
$ns attach - agent $n2 $tcp2
set sink2 [new Agent / TCPSink]
$ns attach - agent $n8 $sink2
set ftp2 [new Application / FTP]
$ftp2 attach - agent $tcp2
$ns connect $ tcp2 $sink2
$tcp2 set class_2
$tcp set packetSize_55
set tfile2 [open cwnd.tr w]
$tcp2 attach $tfile2
$tcp2 trace cwnd_
$ns at 0.5 "ftp1 start"
$ns at 1.0 "ftp2 start"
$ns at 5.0 "ftp2 stop"
$ns at 5.0 "ftp1 stop"
$ns at 5.5 "finish"
$ns run
 

 
