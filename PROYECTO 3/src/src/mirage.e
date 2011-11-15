note
	description: "Summary description for {MIRAGE}."
	author: ""
	date: "$Date$"
	revision: "$Revision$"

class
	MIRAGE




	create
		make

	feature
		modulo:MC72

	feature{ANY}
		make
			do
				create modulo.make
			end



	feature --Esta operacion realiza todos los pasos para atacar a un objetivo

		Atacar_Objetivo(objetivo:STRING)
			local
				flag:INTEGER
				flag2:BOOLEAN
				flag3:BOOLEAN
				intentos:INTEGER

			do
				if(NOT flag2)
				then
					if(NOT flag3)
						then
							modulo.preparar_misil
							print("Se preparo correctamente !!.%N")
						end
					flag:=1
					modulo.Apuntar_Misil(objetivo)
						print("Se apunto correctamente !!.%N")
					flag:=2
					modulo.Lanzar_Misil
						print("Se lanzo correctamente !!.%N")
					end

			rescue
				if(flag=0)
				then
					print("No se pudo atacar al objetivo porque no se pudo preparar el misil.%N")
					flag2:=true
					retry
					end
				if (flag = 1)
			 	then
					if (intentos < 5)
				 	then
				 	print ("No se pudo atacar al objetivo porque no se pudo apuntar el misil.Intento n°: ")
				 	print (intentos+1)
				 	print("%N")
					flag3:=true
				 	intentos := intentos +1
				 	retry
				 else
				 	print("No se pudo atacar al objetivo porque no se pudo apuntar el misil luego de 5 intentos fallidos.%N")
				end
				end

				if(flag=2)
				then
					print("No se pudo atacar al objetivo porque no se pudo lanzar el misil.%N")
				end

end
end
