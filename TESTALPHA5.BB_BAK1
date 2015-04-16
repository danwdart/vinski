; Vinski Blitz Basic Code
; Appname "Vinski"

Graphics 800,600,16,1

dir = LoadImage ("director.png")
bob = LoadImage ("bob.png")
bg = LoadImage ("bg.png")
bar = LoadImage ("barney.png")
hole = LoadImage ("holeguy.png")
welcome = LoadImage ("welcome.png")
cursor  = LoadImage ("cursor.png")


MaskImage dir, 255, 255, 255
MaskImage bob, 255,255,255
MaskImage bar, 255,255,255
MaskImage hole, 255,255,255
MaskImage cursor, 255,255,255



Repeat
SetBuffer BackBuffer()
Cls

DrawImage welcome,0,0
DrawImage dir, 0,200
DrawImage bob, 200,200
DrawImage bar, 400,200
DrawImage hole, 600,200
DrawImage cursor, MouseX(), MouseY()

If Checkmouse (0,200,200,400,1) Then player = dir: Exit
If Checkmouse (200,200,400,400,1) Then player = bob: Exit
If Checkmouse (400,200,600,400,1) Then player = bar: Exit
If Checkmouse (600,200,800,400,1) Then player = hole: Exit


Flip
Until KeyHit (1)


SetBuffer BackBuffer ()


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
If y > 400 Then y = 400


DrawImage bg, 0,0

DrawImage player, x, y	; Draw the image
Flip
Until KeyHit (1)

End

Function Checkmouse (x1,y1,x2,y2,button)
If MouseHit(1) And MouseX() >= x1 And MouseX() <= x2 And MouseY() >= y1 And MouseY() <=y2 Then Return True Else Return False
End Function
