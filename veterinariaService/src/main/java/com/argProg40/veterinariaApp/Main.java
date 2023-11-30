package com.argProg40.veterinariaApp;

import com.argProg40.veterinariaApp.Controller.GatoController;
import com.argProg40.veterinariaApp.Controller.MedicoController;
import com.argProg40.veterinariaApp.Controller.PerroController;
import com.argProg40.veterinariaApp.Controller.Request.MedicoRequestDto;
import com.argProg40.veterinariaApp.Controller.Response.GatoDto;
import com.argProg40.veterinariaApp.Controller.Response.MedicoDto;
import com.argProg40.veterinariaApp.Controller.Response.PerroDto;
import com.argProg40.veterinariaApp.Controller.TurnoMedicoController;
import com.argProg40.veterinariaApp.Templeate.GestorTurnosMedico;
import com.argProg40.veterinariaApp.Templeate.GestorTurnosSecretario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final MedicoController medicoController;
    private final PerroController perroController;

    private final GatoController gatoController;
    private final TurnoMedicoController turnoMedicoController;


    public Main(MedicoController medicoController, PerroController perroController, GatoController gatoController, TurnoMedicoController turnoMedicoController) {
        this.medicoController = medicoController;
        this.perroController = perroController;
        this.gatoController = gatoController;
        this.turnoMedicoController = turnoMedicoController;

    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Gestionar Médicos");
            System.out.println("2. Gestionar Perros");
            System.out.println("3. Gestionar Gatos");
            System.out.println("4. Gestionar Turnos Médicos (Secretario)");
            System.out.println("5. Gestionar Turnos Médicos (Medico)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarMedicos();
                    break;
                case 2:
                    gestionarPerros();
                    break;
                case 3:
                    gestionarGatos();
                    break;
                case 4:
                    gestionarTurnosMedicos();
                    break;
                case 5:
                    gestionarTurnosMedicosMedico();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }


    private void gestionarMedicos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menú Médico -----");
            System.out.println("1. Ver todos los médicos");
            System.out.println("2. Ver médico por ID");
            System.out.println("3. Crear nuevo médico");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verTodosLosMedicos();
                    break;
                case 2:
                    verMedicoPorId();
                    break;
                case 3:
                    crearNuevoMedico();
                    break;
                case 4:
                    System.out.println("Saliendo del menú médico...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }


    private void verTodosLosMedicos() {
        List<MedicoDto> medicos = medicoController.obtenerTodosLosMedicos().getBody();
        System.out.println("----- Listado de Médicos -----");
        medicos.forEach(medico -> System.out.println(medico.toString()));
    }

    private void verMedicoPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del médico: ");
        Long id = scanner.nextLong();

        MedicoDto medico = medicoController.obtenerMedicoPorId(id).getBody();
        if (medico != null) {
            System.out.println("----- Detalle del Médico -----");
            System.out.println(medico.toString());
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    private void crearNuevoMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del médico: ");
        String nombre = scanner.nextLine();

        MedicoRequestDto nuevoMedico = new MedicoRequestDto();
        nuevoMedico.setNombre(nombre);

        medicoController.crearMedico(nuevoMedico);
        System.out.println("Nuevo médico creado exitosamente.");
    }
    private void gestionarPerros() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menú Perros -----");
            System.out.println("1. Ver todos los perros");
            System.out.println("2. Ver perro por ID");
            System.out.println("3. Crear nuevo perro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verTodosLosPerros();
                    break;
                case 2:
                    verPerroPorId();
                    break;
                case 3:
                    crearNuevoPerro();
                    break;
                case 4:
                    System.out.println("Saliendo del menú perros...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void verTodosLosPerros() {
        ResponseEntity<List<PerroDto>> response = perroController.obtenerTodosLosPerros();
        List<PerroDto> perros = response.getBody();

        if (perros != null && !perros.isEmpty()) {
            System.out.println("----- Listado de Perros -----");
            for (PerroDto perro : perros) {
                System.out.println(perro);
            }
        } else {
            System.out.println("No hay perros registrados.");
        }
    }

    private void verPerroPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del perro: ");
        Long id = scanner.nextLong();

        ResponseEntity<PerroDto> response = perroController.obtenerPerroPorId(id);
        PerroDto perro = response.getBody();

        if (perro != null) {
            System.out.println("----- Información del Perro -----");
            System.out.println(perro);
        } else {
            System.out.println("No se encontró un perro con el ID proporcionado.");
        }
    }

    private void crearNuevoPerro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del perro: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la raza del perro: ");
        String raza = scanner.next();


        PerroDto nuevoPerro = new PerroDto();
        nuevoPerro.setNombre(nombre);
        nuevoPerro.setRaza(raza);
        // Setear otros atributos del perro

        ResponseEntity<Void> response = perroController.crearPerro(nuevoPerro);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            System.out.println("Perro creado exitosamente.");
        } else {
            System.out.println("No se pudo crear el perro. Intente de nuevo.");
        }
    }

    private void gestionarGatos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menú Gatos -----");
            System.out.println("1. Ver todos los gatos");
            System.out.println("2. Ver gato por ID");
            System.out.println("3. Crear nuevo gato");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verTodosLosGatos();
                    break;
                case 2:
                    verGatoPorId();
                    break;
                case 3:
                    crearNuevoGato();
                    break;
                case 4:
                    System.out.println("Saliendo del menú gatos...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void verTodosLosGatos() {
        // Utiliza el controlador de Gato para obtener todos los gatos
        ResponseEntity<List<GatoDto>> response = gatoController.obtenerTodosLosGatos();
        List<GatoDto> gatos = response.getBody();

        if (gatos != null && !gatos.isEmpty()) {
            System.out.println("----- Listado de Gatos -----");
            for (GatoDto gato : gatos) {
                System.out.println(gato);
            }
        } else {
            System.out.println("No hay gatos registrados.");
        }
    }

    private void verGatoPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del gato: ");
        Long id = scanner.nextLong();

        // Utiliza el controlador de Gato para obtener un gato por ID
        ResponseEntity<GatoDto> response = gatoController.obtenerGatoPorId(id);
        GatoDto gato = response.getBody();

        if (gato != null) {
            System.out.println("----- Información del Gato -----");
            System.out.println(gato);
        } else {
            System.out.println("No se encontró un gato con el ID proporcionado.");
        }
    }

    private void crearNuevoGato() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del gato: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el color del gato: ");
        String color = scanner.next();

        // Utiliza el controlador de Gato para crear un nuevo gato
        GatoDto nuevoGato = new GatoDto();
        nuevoGato.setNombre(nombre);
        nuevoGato.setColor(color);
        // Setea otros atributos del gato si es necesario

        ResponseEntity<Void> response = gatoController.crearGato(nuevoGato);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            System.out.println("Gato creado exitosamente.");
        } else {
            System.out.println("No se pudo crear el gato. Intente de nuevo.");
        }
    }




    private void gestionarTurnosMedicos() {
        GestorTurnosSecretario gestorTurnosMedico = new GestorTurnosSecretario(turnoMedicoController);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Gestor Turnos Secretario -----");
            System.out.println("1. Ver todos los turnos");;
            System.out.println("2. Registrar un Turno");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestorTurnosMedico.mostrarTurnos().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Ingrese el Id del Medico: ");
                    int idMedico = scanner.nextInt();

                    //Buscamos el medico

                    MedicoDto medicoDto = medicoController.obtenerMedicoPorId((long) idMedico).getBody();

                    //Identificamos que tipo de mascota es
                    System.out.println("Es perro o gato?: ");
                    String respuesta = scanner.next();

                    if(respuesta.equalsIgnoreCase("perro")){
                        System.out.println("Ingrese el id del Perro: ");
                        int idPerro = scanner.nextInt();
                        PerroDto mascota = perroController.obtenerPerroPorId((long) idPerro).getBody();

                        if(mascota == null){
                            System.out.println("Perro no encontrada");return;}

                        System.out.println("Ingrese el monto total: ");
                        float montoTotal = scanner.nextFloat();

                        assert medicoDto != null;
                        gestorTurnosMedico.registrarTurno(medicoDto, mascota.getId(), montoTotal);
                    }
                    else{
                        System.out.println("Ingrese el id del Gato: ");
                        int idGato = scanner.nextInt();
                        GatoDto mascota = gatoController.obtenerGatoPorId((long) idGato).getBody();

                        if(mascota == null){
                            System.out.println("Gato no encontrada");return;}


                        System.out.println("Ingrese el monto total: ");
                        float montoTotal = scanner.nextFloat();

                        assert medicoDto != null;
                        gestorTurnosMedico.registrarTurno(medicoDto, mascota.getId(), montoTotal);
                    }


                    break;
                case 3:
                    System.out.println("Saliendo del menú perros...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }



    }
    private void gestionarTurnosMedicosMedico() {

        System.out.println("Por favor ingrese su Id:");
        int medicoId = new Scanner(System.in).nextInt();

        MedicoDto medico = medicoController.obtenerMedicoPorId((long) medicoId).getBody();

        if (medico == null){
            System.out.println("Medico no encontrado");
            return;
        }

        final GestorTurnosMedico gestorTurnosMedico = new GestorTurnosMedico(turnoMedicoController, medico);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menú Turnos Médicos (Médico) -----");
            System.out.println("1. Ver todos los turnos");
            System.out.println("2. Aprobar turno");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verTodosLosTurnosMedico(gestorTurnosMedico);
                    break;
                case 2:
                    aprobarTurnoMedico(gestorTurnosMedico);
                    break;
                case 3:
                    System.out.println("Saliendo del menú de turnos médicos (Médico)...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void verTodosLosTurnosMedico(GestorTurnosMedico gestorTurnosMedico) {
        gestorTurnosMedico.mostrarTurnos().forEach(System.out::println);
    }

    private void aprobarTurnoMedico(GestorTurnosMedico gestorTurnosMedico) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del turno a aprobar: ");
        int idTurno = scanner.nextInt();

        gestorTurnosMedico.aprobarTurno(idTurno);
    }
}

