#!/bin/sh

while :
do
  echo "Playing animation"
  java -Dcom.sun.javafx.transparentFramebuffer=true -jar Santa.jar
  sleep $[ ( $RANDOM % 60 )  + 60 ]s
done

