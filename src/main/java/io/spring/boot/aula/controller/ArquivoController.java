package io.spring.boot.aula.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.spring.boot.aula.entity.Arquivo;
import io.spring.boot.aula.repository.ArquivoRepository;
import java.io.IOException;
import static org.jboss.logging.MDC.put;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author natan
 */
@RestController
public class ArquivoController {

    @Autowired
    ArquivoRepository arquivoRepository;

    private final GridFsTemplate gridFsTemplate;

    @Autowired
    public ArquivoController(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    @RequestMapping(value = "/arquivo", method = RequestMethod.POST)
    public String save(@RequestParam("file") MultipartFile file) throws IOException {

        DBObject metaData = new BasicDBObject();

        Arquivo arquivo = new Arquivo();

        arquivo.setDescricao(file.getName());

        arquivoRepository.save(arquivo);

        metaData.put("idArquivo", arquivo.getId());

        gridFsTemplate.store(file.getInputStream(), file.getName(), "application/pdf", metaData).save();

        return "Deu certo!";
    }

}
