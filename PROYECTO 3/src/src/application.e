note
	description : "PROYECTO3 application root class"
	date        : "$Date$"
	revision    : "$Revision$"

class
	APPLICATION

inherit
	ARGUMENTS

create
	make

feature {NONE} -- Initialization

	make
		-- Run application.
		local
			mirage : MIRAGE
		do
			print ("Iniciando...%N")
			create mirage.make

			print ("Atacando Objetivo...%N")

			mirage.Atacar_Objetivo ("Rodri")

		
		end

end
