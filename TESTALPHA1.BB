; Vinski Blitz Basic Code
; Appname "Vinski"

Graphics 800,600,16,1
SetBuffer BackBuffer ()
dir = LoadImage ("director.bmp")
bob = LoadImage ("bob.bmp")


bg = LoadImage ("bg.bmp")


bar = LoadImage ("holeguy.bmp")
MaskImage dir, 255, 255, 255
MaskImage bob, 255,255,255
MaskImage bar, 255,255,255
Repeat
Cls

DrawImage bg, 0,0

If MouseDown(1) Then player = bob ElseIf MouseDown(2) Then player = bar Else player = dir

DrawImage player, MouseX (), MouseY()	; Draw the image
Flip
Until KeyHit (1)
End

LoadAnimImage