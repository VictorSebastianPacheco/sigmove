/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sigmove.controlador;

import edu.sigmove.entity.Categoria;
import edu.sigmove.entity.Producto;
import edu.sigmove.facade.CategoriaFacadeLocal;
import edu.sigmove.facade.ProductoFacadeLocal;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;
import org.primefaces.PrimeFaces;
import org.primefaces.shaded.commons.io.FilenameUtils;

/**
 *
 * @author victo
 */
@Named(value = "categoriasView")
@ViewScoped
public class categoriasView implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaFacadeLocal;
    
    @EJB
    private ProductoFacadeLocal productoFacadeLocal;

    private Part filePart;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private ArrayList<Categoria> listaCategorias = new ArrayList<>();
    private Categoria categoriaSelect = new Categoria();
    private String rutaImg = "profile-01.jpg";

    public categoriasView() {
    }

    @PostConstruct
    public void cargaCategorias() {
        try {
            listaCategorias.addAll(categoriaFacadeLocal.findAll());
            categoriaSelect = categoriaFacadeLocal.find(1);
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.cargaCategorias() " + e.getMessage());
        }
    }

    public void seleccionCategoria(int id) {
        try {
            categoriaSelect = categoriaFacadeLocal.find(id);
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.seleccionCategoria() " + e.getMessage());
        }
    }

    public int catidadproductoscategoria(int fk_produto) {
        try {
            return categoriaFacadeLocal.catidadProductoCategoria(fk_produto);
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.catidadproductoscategoria() " + e.getMessage());
            return 0;
        }
    }

    public List<Producto> listaProductos() {
        try {
            return productoFacadeLocal.listaProdutosporcategoria(categoriaSelect.getIdcategoria());
        } catch (Exception e) {
            System.out.println("edu.webapp1966781b.controlador.CategoriasView.listaProductos() " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void accion(String carpeta) {
        String mensajes = "";

        if (filePart != null) {
            if (filePart.getSize() > 4000000) {
                mensajes = "swal('Tamaño del archivo muy Grande !!', 'Intente de nuevo', 'error');";
            } else if (!"image/jpeg".equals(filePart.getContentType())) {
                mensajes = "swal('El archivo no es una imagen valida !!', 'Intente de nuevo', 'error');";
            }
            if (mensajes.equals("")) {
                Categoria catSelect = categoriaFacadeLocal.find(Integer.parseInt(carpeta));
                File folder = new File("C:/LIBRERIA/sigmovefase4/web/imagenes/Productos/Categorias/" + catSelect.getNombre());
                
                if (!folder.exists()) {
                    folder.mkdirs();
                }
                try (InputStream is = filePart.getInputStream()) {
                    Calendar hoy = Calendar.getInstance();
                    String renombraArchivo = sdf.format(hoy.getTime()) + ".";
                    renombraArchivo += FilenameUtils.getExtension(filePart.getSubmittedFileName());
                    Files.copy(is, (new File(folder, renombraArchivo)).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    rutaImg = catSelect.getNombre() + "\\" + renombraArchivo;
                } catch (Exception e) {
                    mensajes = "swal('Por favor !!', 'Intente de nuevo', 'error');";
                }
            }
        } else {
            mensajes = "swal('Por favor !!', 'Intente de nuevo', 'error');";
        }
        PrimeFaces.current().executeScript(mensajes);
    }
    
    public Part getFilePart() {
        return filePart;
    }

    public void setFilePart(Part filePart) {
        this.filePart = filePart;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public Categoria getCategoriaSelect() {
        return categoriaSelect;
    }

    public void setCategoriaSelect(Categoria categoriaSelect) {
        this.categoriaSelect = categoriaSelect;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

    
    /*
    @Override
    public int catidadProductoCategoria( int categoria){
        try {
            Query qt = em.createNativeQuery("SELECT COUNT(*) FROM producto WHERE Idcategoria = ?1");
            qt.setParameter(1, categoria);
            return ((Number)qt.getSingleResult()).intValue();
        } catch (Exception e) {
            return 0;
        }
    }
    */
    /*
    public int catidadProductoCategoria(int fk_produto);
    */
    
}
