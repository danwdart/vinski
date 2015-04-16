; Vinski Blitz Basic Code
AppTitle "JolHargSoftware Vinski"

Graphics 800,600,16,1

; ***************************
; INIT Loading and Masking

dir = LoadImage ("director.png")
bob = LoadImage ("bob.png")
bar = LoadImage ("barney.png")
hole = LoadImage ("holeguy.png")
dragon = LoadImage ("dragon.png")
welcome = LoadImage ("welcome.png")
cursor  = LoadImage ("cursor.png")


MaskImage dir, 255, 255, 255
MaskImage bob, 255,255,255
MaskImage bar, 255,255,255
MaskImage hole, 255,255,255
MaskImage dragon, 255,255,255
MaskImage cursor, 255,255,255

; **********************************
; Choose screen





Repeat
SetBuffer BackBuffer()
Cls

DrawImage welcome,0,0
DrawImage dir, 0,200
DrawImage bob, 200,200
DrawImage bar, 400,200
DrawImage hole, 600,200
DrawImage dragon, 0,400
DrawImage cursor, MouseX(), MouseY()


If Checkmouse (0,200,200,400,1) Then player = dir: Exit
If Checkmouse (200,200,400,400,1) Then player = bob: Exit
If Checkmouse (400,200,600,400,1) Then player = bar: Exit
If Checkmouse (600,200,800,400,1) Then player = hole: Exit
If Checkmouse (0,400,200,600,1) Then player = dragon: Exit


Flip
Until KeyHit (1)

; **********************
; Choose screen 2

Repeat
SetBuffer BackBuffer()
Cls

DrawImage welcome,0,0
DrawImage dir, 0,200
DrawImage bob, 200,200
DrawImage bar, 400,200
DrawImage hole, 600,200
DrawImage dragon, 0,400
DrawImage cursor, MouseX(), MouseY()


If Checkmouse (0,200,200,400,1) Then player2 = dir: Exit
If Checkmouse (200,200,400,400,1) Then player2 = bob: Exit
If Checkmouse (400,200,600,400,1) Then player2 = bar: Exit
If Checkmouse (600,200,800,400,1) Then player2 = hole: Exit
If Checkmouse (0,400,200,600,1) Then player2 = dragon: Exit

Flip
Until KeyHit (1)


; **************************************************************
; Play

For I = 1 To 2 ;Levels

bg = LoadImage ("bg" + I + ".png")



SetBuffer BackBuffer ()


Repeat

	Cls
	
	If KeyDown (203) Then x = x - 10 ; Left cursor
	If KeyDown (205) Then x = x + 10 ; Right cursor
	If KeyDown (200) Then y = y - 10 ; Up cursor
	If KeyDown (208) Then y = y + 10 ; Down cursor

	If KeyDown (75) Then x2 = x2 - 10 ; 4
	If KeyDown (77) Then x2 = x2 + 10 ; 6
	If KeyDown (72) Then y2 = y2 - 10 ; 8
	If KeyDown (80) Then y2 = y2 + 10 ; 2



If KeyDown (16) Then player = dir ;Q
If KeyDown (17) Then player = bob ;W
If KeyDown (18) Then player = bar ;E
If KeyDown (19) Then player = hole ;R
If KeyDown (20) Then player = dragon ;T

If KeyDown (21) Then player2 = dir ;Y
If KeyDown (22) Then player2 = bob ;U
If KeyDown (23) Then player2 = bar ;I
If KeyDown (24) Then player2 = hole ;O
If KeyDown (25) Then player2 = dragon ;P


If y < 250 Then y = 250
If x < 0 Then x = 0
If x > 600 Then x = 600
If y > 400 Then y = 400

If y2 < 250 Then y2 = 250
If x2 < 0 Then x2 = 0
If x2 > 600 Then x2 = 600
If y2 > 400 Then y2 = 400

DrawImage bg, 0,0

DrawImage player, x, y	; Draw the image
DrawImage player2, x2, y2
Flip
Until KeyHit (1)

Next




; *******************************************************
; End of play

End

; *******************************************************
; Functions

Function Checkmouse (x1,y1,x2,y2,button)
If MouseHit(1) And MouseX() >= x1 And MouseX() <= x2 And MouseY() >= y1 And MouseY() <=y2 Then Return True Else Return False
End Function