; Vinski Blitz Basic Code
AppTitle "JolHargSoftware Vinski"

Graphics 800,600,16,1

; ***************************
; INIT Loading and Masking

Global player
Global player2

dir = LoadImage ("director.png")
bob = LoadImage ("bob.png")
barl = LoadImage ("barneyl.png")
barr = LoadImage ("barneyr.png")
hole = LoadImage ("holeguy.png")
dragonl = LoadImage ("dragonl.png")
dragonr = LoadImage ("dragonr.png")
welcome = LoadImage ("welcome.png")
cursor  = LoadImage ("cursor.png")


MaskImage dir, 255,255,255
MaskImage bob, 255,255,255
MaskImage barl, 255,255,255
MaskImage barr, 255,255,255
MaskImage hole, 255,255,255
MaskImage dragonl, 255,255,255
MaskImage dragonr, 255,255,255
MaskImage cursor, 255,255,255

; **********************************
; Choose screen




SetBuffer BackBuffer()
Repeat

Cls

DrawImage welcome,0,0
DrawImage dir, 0,200
DrawImage bob, 200,200
DrawImage barr, 400,200
DrawImage hole, 600,200
DrawImage dragonl, 0,400
DrawImage cursor, MouseX(), MouseY()

Message 300,100,"Player 1"

If Checkmouse (0,200,200,400,1)=True Then
player = dir
Exit:Exit
ElseIf Checkmouse (200,200,400,400,1)= True Then
player = bob
Exit:Exit
ElseIf Checkmouse (400,200,600,400,1)=True Then
player = barr
Exit:Exit
ElseIf Checkmouse (600,200,800,400,1)=True Then
player = hole
Exit:Exit
ElseIf Checkmouse (0,400,200,600,1)=True Then
player = dragonl
Exit:Exit
End If

Flip
Forever

; **********************
; Choose screen 2

Repeat
SetBuffer BackBuffer()
Cls

DrawImage welcome,0,0
DrawImage dir, 0,200
DrawImage bob, 200,200
DrawImage barr, 400,200
DrawImage hole, 600,200
DrawImage dragonl, 0,400
DrawImage cursor, MouseX(), MouseY()

Message 300,100,"Player 2"

If Checkmouse (0,200,200,400,1)=True Then
player2 = dir
Exit:Exit
ElseIf Checkmouse (200,200,400,400,1)=True Then
player2 = bob
Exit:Exit
ElseIf Checkmouse (400,200,600,400,1)=True Then
player2 = barr
Exit:Exit
ElseIf Checkmouse (600,200,800,400,1)=True Then
player2 = hole
Exit:Exit
ElseIf Checkmouse (0,400,200,600,1)=True Then
player2 = dragonl
Exit:Exit

End If

Flip
Forever


; **************************************************************
; Play

For I = 1 To 7 ;Levels
LevMessage ("Level "+Str (I),True)
If ChannelPlaying (chnMusic) = True Then StopChannel (chnMusic)
bg = LoadImage ("bg" + I + ".png")
chnMusic = PlayMusic ("mus" + I + ".mp3")




SetBuffer BackBuffer ()

	x = 0
	y = 250
	x2 = 600
	y2 = 250

Repeat

	Cls



	If KeyDown (203) Then x = x - 20 ; Left cursor
	If KeyDown (205) Then x = x + 20 ; Right cursor
	If KeyDown (200) Then y = y - 20 ; Up cursor
	If KeyDown (208) Then y = y + 20 ; Down cursor

	If KeyDown (75) Then x2 = x2 - 20 ; 4
	If KeyDown (77) Then x2 = x2 + 20 ; 6
	If KeyDown (72) Then y2 = y2 - 20 ; 8
	If KeyDown (80) Then y2 = y2 + 20 ; 2



If KeyDown (16) Then player = dir ;Q
If KeyDown (17) Then player = bob ;W
If KeyDown (18) Then player = barr ;E
If KeyDown (19) Then player = hole ;R
If KeyDown (20) Then player = dragonl ;T

If KeyDown (21) Then player2 = dir ;Y
If KeyDown (22) Then player2 = bob ;U
If KeyDown (23) Then player2 = barr ;I
If KeyDown (24) Then player2 = hole ;O
If KeyDown (25) Then player2 = dragonl ;P

If KeyDown (203) And player = barr Then player = barl
If KeyDown (205) And player = barl Then player = barr

If KeyDown (203) And player = dragonr Then player = dragonl
If KeyDown (205) And player = dragonl Then player = dragonr

If KeyDown (75) And player2 = barr Then player2 = barl
If KeyDown (77) And player2 = barl Then player2 = barr

If KeyDown (75) And player2 = dragonr Then player2 = dragonl
If KeyDown (77) And player2 = dragonl Then player2 = dragonr

If beam1 <> 0 Then  beam1 = beam1 + 30
If beam2 <> 0 Then  beam2 = beam2 - 30

If  beam12 <> 0 Then beam12 = beam12 + 30
If beam22 <> 0 Then beam22 = beam22-30

If KeyDown (28) Then Line x+beam1,y+100,x+beam1+100,y+100: Line x+beam2,y+100,x+beam2+100,y+100 ;  Enter
If KeyDown (76) Then Line x2+beam12,y2+100,x2+beam12+100,y2+100: Line x2+beam22,y2+100,x2+beam22+100,y2+100 ; 5

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
If ChannelPlaying (chnMusic) = False Then chnMusic = PlayMusic ("mus" + I + ".mp3")

Until KeyHit(1)

Next

If ChannelPlaying (chnMusic) Then StopChannel (chnMusic)


; *******************************************************
; End of play

End

; *******************************************************
; Functions

Function Checkmouse (x1,y1,x2,y2,button)
If MouseHit(1) And MouseX() >= x1 And MouseX() <= x2 And MouseY() >= y1 And MouseY() <=y2 Then Return True Else Return False
End Function

Function LevMessage (message$,C)
SetBuffer FrontBuffer()
If C Then Cls
fntTimes = LoadFont ("Times New Roman",36,False,False,False)
SetFont fntTimes
Color 127,127,127
Text 100,100,message$
Text 200,200,"Click to continue..."
WaitMouse
FreeFont fntTimes
End Function

Function Message (xpos,ypos,mess$)

fntTimes = LoadFont ("Times New Roman",36,False,False,False)
SetFont fntTimes
Color 127,127,127
Text xpos,ypos,mess$
FreeFont fntTimes

End Function

