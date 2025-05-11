package com.erp.cadastrocliente.model;

import com.erp.cadastrocliente.util.AppUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  private String email;

  private byte[] logotipo;

  @OneToMany(
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY,
    mappedBy = "cliente"
  )
  @JsonIgnoreProperties(value = "cliente")
  @ToString.Exclude
  private List<Endereco> enderecos;

  public void setEnderecos(List<Endereco> enderecos) {
//    this.enderecos.clear();
    this.enderecos = enderecos;
    this.enderecos.forEach(endereco -> endereco.setCliente(this));

  }

  public void setLogotipo(MultipartFile logotipo) {
    this.logotipo = AppUtil.multipartFileToBinary(logotipo);
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Class<?> oEffectiveClass = o instanceof HibernateProxy
      ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
      : o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy
      ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
      : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    Cliente cliente = (Cliente) o;
    return getId() != null && Objects.equals(getId(), cliente.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
      .getPersistentClass().hashCode() : getClass().hashCode();
  }
}
