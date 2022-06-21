#!/bin/env sh

# check sudo permissions
if (( "$EUID" != 0 )); then
  echo "Please run this script with sudo"
  exit 1
fi


INSTALL_PATH=/usr/share/java/jls
VERSION=0.3.2

mkdir -p "$INSTALL_PATH"

echo "Install version: $VERSION"
echo "Downloading jar file..."
sudo curl https://github.com/Anas-Elgarhy/jls/releases/download/"$VERSION"/jls.main.jar \
  --output "$INSTALL_PATH"/jls.jar

printf "\nDownloaded in %s/jls.jar\n" $INSTALL_PATH

echo "Create the executable file in /bin"
# shellcheck disable=SC2024
sudo echo "exec /usr/bin/java -jar $INSTALL_PATH/jls.jar" >>  /bin/jls

sudo chmod +x /bin/jls

printf "\nDone, enjoy :D\n"

echo "Please type jls --help to show the available options"
echo "If the icons do not appear or appear wrongly, please make sure that you have installed nerd font"
