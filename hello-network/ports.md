# Ports
- Well known ports: 0 ~ 1023
- Registered ports: 1024 ~ 49151
- Dynamic and Private ports: 49152 ~ 65535

By running
```
	cat /etc/services
```
we can view port numbers and service mappings.

```
	netstat -tulpn | grep LISTEN
```
can list open ports.
```
	-t: All TCP ports
	-u: All UDP ports
	-l: Display listening server sockets
	-p: Show the PID and name of the program to which each socket belongs
	-n: Don't resolve names
```

```
	lsof -i -P -n | grep LISTEN
```
can check listening ports and applications.
```
	-i: Look for listening ports
	-P: Inhibits the conversion of port numbers to port names for network files
	-n: Don't use DNS name
```
