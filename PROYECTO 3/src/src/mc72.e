note
	description: "Summary description for {MC72}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MC72

	create
		make

feature {ANY}
		make
		do
			create misil.make
		end

	feature
		misil:MISIL





	feature  --Esta operacion prepara un misil

		Preparar_Misil

			local

				r:RANDOM
				flag:INTEGER
				flag2:BOOLEAN

			do
				if(NOT flag2)
					then
					flag:=0
					Setup_misil
					end
					flag:=1
					Cargar_misil



			rescue
				if(flag=0)
				then
					print("No se pudo preparar el misil  porque que no hay misiles.%N")
				else
					print("No se pudo preparar el misil porque el material esta defectuoso,se intentara nuevamente...%N")
					flag2:=true
					retry
					end


	end




	feature --Esta operación fija el blanco del misil.

		Apuntar_Misil(objetivo:STRING)
			do
				misil.fijar_blanco (objetivo)
			rescue
				print("No se pudo apuntar el misil porque la memoria del misil esta defectuosa.%N")
			end



	feature --Esta operación le ordena al misil  que despegue.

		Lanzar_Misil
			do
				misil.despegar
			rescue
				print("No se pudo hacer despegar el misil ya que el misil no tiene combustible.%N")
			end


	feature --Esta operacion controla que haya misiles en stock

		Hay_misiles:BOOLEAN

			local
			r : RANDOM
			t : DATE_TIME
			resultado:BOOLEAN
			do
				create r.make
				create t.make_now
				r.set_seed (t.seconds)
				resultado:=(r.next_random (t.seconds) \\ 2) = 0
				Result:=resultado

			end






	feature --Esta operación crea un misil.


		Setup_Misil
			local
				hayMisiles:BOOLEAN
				r:RANDOM
				do
					hayMisiles:=Hay_Misiles

					if(hayMisiles)
					then
						create misil.make
						else

							create r.make
							r := void
							r.set_seed (1)
					end
			end


	feature --Esta operación activa el misil.

		Cargar_Misil
					do
					misil.Activar
					end









end
