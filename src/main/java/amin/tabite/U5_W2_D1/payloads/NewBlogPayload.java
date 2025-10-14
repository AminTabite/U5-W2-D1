package amin.tabite.U5_W2_D1.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class NewBlogPayload {

    private String categoria;
    private  String titolo;
    private String contenuto;
    private int tempolettura;


    public NewBlogPayload(String categoria, String titolo, String contenuto, int tempolettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.contenuto = contenuto;
        this.tempolettura = tempolettura;
    }
}
