package org.example.ejb.rest;

import org.example.remote.ResponseRemote;
import org.example.remote.dto.DisciplineDto;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

@Singleton
public class DisciplineRest {

    private final String url = "https://localhost:443/LabService";

    private Client client;

    @PostConstruct
    public void init() throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        FileInputStream writeStream = new FileInputStream("C:\\soa_lab3\\keystore.jks");
        trustStore.load(writeStream, new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});

        this.client = ClientBuilder.newBuilder().trustStore(trustStore).build();
    }

    public ResponseRemote createDiscipline(DisciplineDto discipline) {
        Response response = this.client.target(url + "/api/v1/bars/discipline")
                .request().post(Entity.entity(discipline, MediaType.APPLICATION_JSON_TYPE));

        return new ResponseRemote(response.getStatus(), response.readEntity(String.class));
    }

    public ResponseRemote getAllDiscipline(String name, Integer pageNumber, Integer pageSize) {
        Response response = this.client.target(url + "/api/v1/bars/discipline")
                .queryParam("name", name)
                .queryParam("pageNumber", pageNumber)
                .queryParam("pageSize", pageSize)
                .request().get();

        return new ResponseRemote(response.getStatus(), response.readEntity(String.class));
    }

    public ResponseRemote getAllLab(Long id, Integer pageNumber, Integer pageSize) {
        Response response = this.client.target(url + "/api/v1/bars/discipline/" + id + "/lab")
                .queryParam("pageNumber", pageNumber)
                .queryParam("pageSize", pageSize)
                .request().get();

        return new ResponseRemote(response.getStatus(), response.readEntity(String.class));
    }

    public ResponseRemote deleteDisciplineById(Long id) {
        Response response = this.client.target(url + "/api/v1/bars/discipline/" + id)
                .request().delete();

        return new ResponseRemote(response.getStatus(), response.readEntity(String.class));
    }

    public ResponseRemote addLabToDiscipline(Long disciplineId, Long labId) {
        Response response = this.client.target(url + "/api/v1/bars/discipline/" + disciplineId + "/labwork/" + labId + "/add")
                .request().post(null);

        return new ResponseRemote(response.getStatus(), null);
    }

    public ResponseRemote removeLabToDiscipline(Long disciplineId, Long labId) {
        Response response = this.client.target(url + "/api/v1/bars/discipline/" + disciplineId + "/labwork/" + labId + "/remove")
                .request().delete();

        return new ResponseRemote(response.getStatus(), response.readEntity(String.class));
    }
}
