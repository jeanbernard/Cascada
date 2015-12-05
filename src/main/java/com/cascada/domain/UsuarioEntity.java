package com.cascada.domain;

import javax.persistence.*;

/**
 * Created by Jalissa on 12/5/2015.
 */
@Entity
@Table(name = "USUARIO", schema = "Cascada", catalog = "")
@NamedQueries({
        @NamedQuery(name=UsuarioEntity.LOGIN_USUARIO, query="Select p from UsuarioEntity p where p.nombreUsuario=:nombreUsuario and p.clave = :clave")
})

public class UsuarioEntity {

    public static final String LOGIN_USUARIO = "loginUsuario";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @Basic
    @Column(name = "NOMBRE_USUARIO", nullable = false, length = 60)
    private String nombreUsuario;

    @Basic
    @Column(name = "CLAVE", nullable = false, length = 60)
    private String clave;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
