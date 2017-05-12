convert -coalesce santa.gif frames/%02d.png
montage frames/*.png -background none -tile 12x -geometry +0+0 santa-sprite.png