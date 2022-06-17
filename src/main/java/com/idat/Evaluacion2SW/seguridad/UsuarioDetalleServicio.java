package com.idat.Evaluacion2SW.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.Evaluacion2SW.model.Usuario;
import com.idat.Evaluacion2SW.repository.UsuarioRepository;

@Service
public class UsuarioDetalleServicio implements UserDetailsService{

	@Autowired
	private UsuarioRepository usurepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario usuario = usurepo.findByUsuario(username);
		if(usuario != null) {
			List<GrantedAuthority> granted = new ArrayList<GrantedAuthority> ();
			
			GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol());
			granted.add(authority);
			
			return new User(usuario.getUsuario(), usuario.getPassword(), granted);
			
		}else {
			throw new UsernameNotFoundException("El usuario no existe");

		}
	}
}
