package com.jacarandanotas;

import com.jacarandanotas.bloc.Bloc;
import com.jacarandanotas.bloc.BlocException;
import com.jacarandanotas.notas.NotaAlarmaException;

public class MainBloc {

	public static void main(String[] args) {

		Bloc bloc = new Bloc("Personal");
		try {
			System.out.println(bloc);
			bloc.updateNota(0, "Mi primera nota");
			System.out.println(bloc);
			bloc.activa(0);
			System.out.println(bloc);
			bloc.desactiva(0);
			System.out.println(bloc.ordenaBloc());
		} catch (NotaAlarmaException e) {
			e.printStackTrace();
		} catch (BlocException e) {
			e.printStackTrace();
		}

	}

}
