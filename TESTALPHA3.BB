; Vinski Blitz Basic Code
; Appname "Vinski"

Graphics 800,600,16,1

dir = LoadImage ("director.png")
bob = LoadImage ("bob.png")


bg = LoadImage ("bg.png")


bar = LoadImage ("barney.png")
hole = LoadImage ("holeguy.png")

welcome = LoadImage ("welcome.png")
MaskImage dir, 255, 255, 255
MaskImage bob, 255,255,255
MaskImage bar, 255,255,255
MaskImage hole, 255,255,255

x = 320
y = 250


Repeat
SetBuffer BackBuffer()
Cls

DrawImage welcome,0,0
DrawImage dir, 0,200
DrawImage bob, 200,200
DrawImage bar, 400,200
DrawImage hole, 600,200
Flip
Until MouseHit (1)


SetBuffer BackBuffer ()












player = dir
Repeat

	Cls

	If KeyDown (203) Then x = x - 10 ; Left cursor
	If KeyDown (205) Then x = x + 10 ; Right cursor
	If KeyDown (200) Then y = y - 10 ; Up cursor
	If KeyDown (208) Then y = y + 10 ; Down cursor

If KeyDown (16) Then player = dir ;Q
If KeyDown (17) Then player = bob ;W
If KeyDown (18) Then player = bar ;E
If KeyDown (19) Then player = hole ;R

If y < 250 Then y = 250
If x < 0 Then x = 0
If x > 600 Then x = 600


DrawImage bg, 0,0

DrawImage player, x, y	; Draw the image
Flip
Until KeyHit (1)
End