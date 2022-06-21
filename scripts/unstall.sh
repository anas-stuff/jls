#!/bin/env sh

if (( "$EUID" != 0 )); then
  echo "Please this script with sudo!"
  exit 1
fi

echo "Remove jar file.."
sudo rm -r /usr/share/java/jls

echo "Remove execrable file..."
sudo rm /bin/jls

echo "Done :/"

