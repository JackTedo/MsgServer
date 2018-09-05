import socket
import sys

clientsocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
clientsocket.connect(('localhost', 5555))
clientsocket.send(sys.argv[1])
clientsocket.send(sys.argv[2])
