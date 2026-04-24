package com.movivio.movivio_api.Controller;

import com.movivio.movivio_api.Model.Content;
import com.movivio.movivio_api.Service.ContentService;
import com.movivio.movivio_api.dto.ContentWithRating;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void registrarContent(@RequestBody Content content){
        contentService.guardarContent(content);
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
