;Shooting left out. Enclosed in <S>

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

Message 0,0, "Welcome to Vinski"
Message 0,50, "The Vinski were a race of alien monsters constantly trying to"
Message 0,100, "kill each other. Now they return, in this game. Now you are"
Message 0,150, "to play as them, and kill each other in this two player game."

;<S>
;Message 0,250, "Player 1 Controls: Arrow keys and Enter to shoot."
;Message 0,300, "Player 2 Controls: Numpad keys, 4 left, 6 Right, 8 up, 2 down,"
;Message 0,350, "5 To shoot."
;</S>

Message 0,550, "Click to continue..."
Flip
WaitMouse



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

If MouseHit(1) Then
If MouseY() >=200 And MouseY() <=400 Then

If MouseX() >=0 And MouseX() <=200 Then player = dir:Exit:Exit
If MouseX() >=200 And MouseX() <=400 Then player = bob:Exit:Exit
If MouseX() >=400 And MouseX() <=600 Then player = barr:Exit:Exit
If MouseX() >=600 And MouseX() <=800 Then player = hole:Exit:Exit

ElseIf MouseY() >=400 And MouseY() <=600 Then

If MouseX() >=0 And MouseX() <=200 Then player = dragonl:Exit:Exit

End If
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

If MouseHit(1) Then
If MouseY() >=200 And MouseY() <=400 Then

If MouseX() >=0 And MouseX() <=200 Then player2 = dir:Exit:Exit
If MouseX() >=200 And MouseX() <=400 Then player2 = bob:Exit:Exit
If MouseX() >=400 And MouseX() <=600 Then player2 = barr:Exit:Exit
If MouseX() >=600 And MouseX() <=800 Then player2 = hole:Exit:Exit

ElseIf MouseY() >=400 And MouseY() <=600 Then

If MouseX() >=0 And MouseX() <=200 Then player2 = dragonl:Exit:Exit

End If
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

;S
	;player1lives = 5
	;player2lives = 5
;S

	If I = 1 Then inc = 1 Else inc = 10 ;simulate moon gravity


Repeat

	Cls



If KeyDown (203) Then x = x - inc ; Left cursor
If KeyDown (205) Then x = x + inc ; Right cursor
If KeyDown (200) Then y = y - inc ; Up cursor
If KeyDown (208) Then y = y + inc ; Down cursor

If KeyDown (75) Then x2 = x2 - inc ; 4
If KeyDown (77) Then x2 = x2 + inc ; 6
If KeyDown (72) Then y2 = y2 - inc ; 8
If KeyDown (80) Then y2 = y2 + inc ; 2



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

; *************************************************
; Shooting


;xs = X shot pos
;ys = Y shot pos
;x2s = X shot pos player 2
;y2s = Y shot pos player 2

;If KeyDown (28) Then xs = x:ys = y:player1shoot = 1: gun1p1 = xs+100: gun2p1 = xs+100 ;  Enter
;If KeyDown (76) Then x2s = x2:y2s = y2:player2shoot = 1: gun1p2 = x2s+100: gun2p2 = x2s+100 ;  5

;If gun1p1 = 800 Then player1shoot = 0
;If gun2p1 = 0 Then player1shoot = 0
;If gun1p2 = 800 Then player2shoot = 0
;If gun2p2 = 0 Then player2shoot = 0

; *******************
; Check if being shot starts

;If (ys => y2 And ys <=y2+200) And (xs =>x2 And xs <= x2+200) And player1shoot = 1 Then player2lives = player2lives - 1
;If (y2s => y And y2s <=y+200) And (x2s =>x And x2s <= x+200) And player2shoot = 1 Then player1lives = player2lives - 1

;If (gun1p1 => x2 And gun1p1 <=x2+200) And (gun2p1 =>x2 And gun2p1 <= x2+200) And player1shoot = 1 Then player2lives = player2lives - 1:gun1p1=-255
;If (gun1p2 => x And gun1p2 <=x+200) And (gun2p2 =>x And gun2p2 <= x+200) And player2shoot = 1 Then player1lives = player1lives - 1:gun2p2=0


;If (y2s => y And y2s <=y+200) And (x2s =>x And x2s <= x+200) And player2shoot = 1 Then player1lives = player2lives - 1



;If player1lives = 0 Then Exit:Exit: LevMessage ("Player 2 wins this level!!!",True)
;If player2lives = 0 Then Exit:Exit: LevMessage ("Player 1 wins this level!!!",True)




;*****************************************
; End of shooting


If y < 0 Then y = 0
;If y < 250 Then y = 250

If x < 0 Then x = 0
If x > 600 Then x = 600
If y > 400 Then y = 400

;If y2 < 250 Then y2 = 250
If y2 < 0 Then y2 = 0

If x2 < 0 Then x2 = 0
If x2 > 600 Then x2 = 600
If y2 > 400 Then y2 = 400

;CONTACT SENSORS

;If x < x2 + 200 Then x = x2 + 200
;If x > x2 Then x = x2
;If y < y2

;CS


DrawImage bg, 0,0
;If player1shoot = 1 Then gun1p1 = gun1p1 + 30: gun2p1 = gun2p1 -30: Line gun1p1,ys + 100,gun1p1+100,ys+100:Line gun2p1,ys+100,gun2p1+100,ys+100
;If player2shoot = 1 Then gun1p2 = gun1p2 + 30: gun2p2 = gun2p2 -30: Line gun1p2,y2s + 100,gun1p2+100,y2s+100:Line gun2p2,y2s+100,gun2p2+100,y2s+100


DrawImage player, x, y
DrawImage player2, x2, y2
;Text 0,550,"Player 1 lives: "+player1lives+" Player 2 lives: "+player2lives


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