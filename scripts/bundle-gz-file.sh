#!/bin/env sh
if [ -f ".temp" ]; then
  rm -r ./.temp/
fi

mkdir ./.temp/
cp ../out/artifacts/jls_main_jar/jls.jar ./.temp/
cp ./jls.sh ./.temp/


cp ../out/artifacts/jls_main_jar/jls.jar .
cp ./jls.sh .

cd .temp

ls

VER="$1"
echo "Create tar file to jls $VER ..."
TARNAME=jls-"$VER".tar.gz
tar -cvf "./$TARNAME" ./jls.sh ./jls.jar

cd ../..
if ! [ -f "./release" ]; then
  echo "Create release file"
  mkdir release 
fi

echo "Move the $TARNAME to release directory."

mv "./scripts/.temp/$TARNAME" ./release

echo "Remove temp folder"
rm -r ./scripts/.temp
