


package libreria;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Libreria {
    private Map<String, List<Libro>> librosPorAutor;
    public Libreria() {
        librosPorAutor = new HashMap<>();
    }
    public void agregarLibro(Libro libro) {
        String autor = libro.getAutor();
        List<Libro> libros = librosPorAutor.getOrDefault(autor, new ArrayList<>());
        libros.add(libro);
        librosPorAutor.put(autor, libros);
    }
    public void modificarLibro(Libro libro) {
        String autor = libro.getAutor();
        List<Libro> libros = librosPorAutor.getOrDefault(autor, new ArrayList<>());

        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equals(libro.getTitulo())) {
                libros.set(i, libro);
                return;
            }
        }

        libros.add(libro);
        librosPorAutor.put(autor, libros);
    }
    
    
    
    
    public Libro compraSegura(String autor) {
        List<Libro> libros = librosPorAutor.getOrDefault(autor, new ArrayList<>());
        if (libros.isEmpty()) {
            return null;
        }
        Libro mejorCritica = libros.get(0);
        for (Libro libro : libros) {
            if (libro.getCalificacionCritica() > mejorCritica.getCalificacionCritica()) {
                mejorCritica = libro;
            }
        }
        return mejorCritica;
    }
    public List<Libro> listado(String especialidad) {
        List<Libro> librosEspecialidad = new ArrayList<>();

        for (List<Libro> libros : librosPorAutor.values()) {
            for (Libro libro : libros) {
                if (libro.getEspecialidad().equals(especialidad)) {
                    librosEspecialidad.add(libro);
                }
            }
        }

        librosEspecialidad.sort((l1, l2) -> l2.getVentas() - l1.getVentas());

        return librosEspecialidad;
    }
}



class Libro {
    private String titulo;
    private String autor;
    private int ventas;
    private int calificacionCritica;
    private String especialidad;
    private String comentarios;
    public Libro(String titulo, String autor, int ventas, int calificacionCritica, String especialidad, String comentarios) {
        this.titulo = titulo;
        this.autor = autor;
        this.ventas = ventas;
        this.calificacionCritica = calificacionCritica;
        this.especialidad = especialidad;
        this.comentarios = comentarios;
    }
    // Getters y setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
    
    public int getVentas() {
        return ventas;
    }
    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
    public int getCalificacionCritica() {
        return calificacionCritica;
    }
    public void setCalificacionCritica(int calificacionCritica) {
        this.calificacionCritica = calificacionCritica;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ventas=" + ventas +
                ", calificacionCritica=" + calificacionCritica +
                ", especialidad='" + especialidad + '\'' +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}

