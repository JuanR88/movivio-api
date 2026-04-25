package com.movivio.movivio_api.Controller;

import com.movivio.movivio_api.Model.Content;
import com.movivio.movivio_api.Service.ContentService;
import com.movivio.movivio_api.dto.ContentWithRating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService){
        this.contentService=contentService;
    }

    /**
    @GetMapping("/holaContent")
    public String comprueboContent(){return "Hola que tal desde Content";}
    **/

    /**
     Guardar content
     */
    @PostMapping("/content")
    public ResponseEntity<String> registrarContent(@RequestBody Content content){
        String mensaje = contentService.guardarContent(content);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    /**
     *Mostrar todo el Content
     */
    @GetMapping("/content")
    public List<Content> mostrarContent(){return contentService.mostrarContent();}

    /**
     * Muestra detalles de una content
     */
    @GetMapping("/content/{id}")
    public Content detallesContent(@PathVariable Long id){ return contentService.detallesContent(id);}

    /**
     * Obtengo la media para despues implementarla
     **/
    @GetMapping("/content/{id}/media")
    public double mediaRating(@PathVariable Long id){ return contentService.mediaRating(id);}

    /**
     * Saco el top
     */
    @GetMapping("/content/top")
    List<ContentWithRating>topContent(){ return contentService.topContent();}
}
