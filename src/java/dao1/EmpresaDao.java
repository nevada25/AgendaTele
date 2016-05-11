package dao1;

import bean.Empresa;
import java.util.List;

public interface EmpresaDao {
    public List<Empresa> ListarEmpresa();
    public boolean InsertEmpresa(Empresa e);
    public boolean UpdateEmpresa(Empresa e);
    public boolean DeleteEmpresa(Empresa e);
    public Empresa SearchEmpresaid(String id_empresa);
}
