note
	description: "Summary description for {MISIL}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MISIL

	create
		make

		feature --Constructor

			make
			do
			end

	feature  --Esta operación activa el material explosivo en el misil.
		Activar

		local
			r : RANDOM
			t : DATE_TIME
			aux:INTEGER
			do
				create r.make
				create t.make_now
				r.set_seed (t.seconds)


				if ((r.next_random (t.seconds) \\ 2) = 0)
					then

							r := void
							r.set_seed (t.seconds)

				end

			end

	feature  --Esta operacion carga en la memoria del misil el objetivo

		blanco:STRING

		Fijar_Blanco(objetivo:STRING)

		local
			r : RANDOM
			t : DATE_TIME
			do
				blanco:=objetivo
				create r.make
				create t.make_now
				r.set_seed (t.seconds)
				if ((r.next_random (t.seconds) \\ 3) = 0)
					then
							r := void
							r.set_seed (t.seconds)

				end

			end


	feature  --Esta operación hace que el misil salga volando en busca de su objetivo


		Despegar

		local
			r : RANDOM
			t : DATE_TIME
			do
				create r.make
				create t.make_now
				r.set_seed (t.seconds)
				if ((r.next_random (t.seconds) \\ 4) = 0)
					then
							r := void
							r.set_seed (t.seconds)
				end

			end







end
