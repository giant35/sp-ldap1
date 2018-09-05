/*
 *  copyright (c) thelook.cn
 */
package demo.spldap1;

import java.security.Principal;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 老唐
 */
@RestController
public class TestController {

    private final static Logger LOG = LoggerFactory.getLogger(TestController.class);

    @GetMapping(path = "/test/msg")
    public String msg(Principal p, int id) {
        final Collection<? extends GrantedAuthority> as
                = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        LOG.info("p:{},as:{}", p, as);
        return "你好" + id + " p:" + p.getName()+" as:"+as;
    }
}
