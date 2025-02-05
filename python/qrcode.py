import qrcode

img = qrcode.make("https://open.spotify.com/")

img.save("search.png")