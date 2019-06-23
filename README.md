# Buen Trabajo
Proyecto 'Buen Trabajo' para el curso de android

### Prioridades en historias de usuario :

### Alta
* Listado de actividades
* Postular a actividad
* Publicar actividad
* Registro de usuario

### Media
* Perfil de usuario
* Estado de postulación a actividades
* Mantenimiento de actividades

### Baja
* Puntuar compañeros
* Suscripción

**Importante**: Revisar los TODOs del proyecto

[todo]:https://i.gyazo.com/966baeca67203fdbc7f85319d342a241.png "TODOs en android studio"

![alt text][todo]

## Instrucciones para colaborar

Bueno chicos, debido a que Cachi avanzó el proyecto sin llevar el control de versión decidimos que él sea el master ahora, así que lo que tienen que hacer es lo siguiente.

1. Entran a la url https://github.com/Anthonyca18m/APPGODJOOB y le dan a la opción de la esquina superior derecha que dice 'Fork'

[fork]:https://i.gyazo.com/576cccd2d9c45ada41b72f7f1f9cef05.png "Fork"

>![alt text][fork]

2. Esto les dará una copia exacta del proyecto en su propio repositorio por lo cual ahora deben clonarlo en su Pc local, para ello le dan click al portapapeles que sale a la derecha de 'https://github.com/...'

[cloning]:https://i.gyazo.com/eb472523db3a22b4a793c67e0e7f1ab5.png "cloning"
>![alt text][cloning]

3. Abren la consola de git(de usar windows) o la terminal de linux ubicados en el lugar donde vayan a almacenar el repositorio del proyecto y escriben el siguiente comando:

```bash
git clone https://github.com/FeoRosonskiDev/APPGODJOOB.git GoodJobProject
```

Cabe recalcar que donde dice 'FeoRosonskiDev' irá su propio nombre de usuario de git, pero no es necesario que lo escriban a mano, ya que lo tienen copiado en el portapapeles, así que basta con click derecho -> pegar

4. El siguiente paso es ubicar la consola en la carpeta que contiene el proyecto:

```bash
cd GoodJobProject
```

5. Ya ubicados en esa carpeta el siguiente comando es:

```bash
git remote add main https://github.com/Anthonyca18m/APPGODJOOB
```

**OJO: este comando es tal cual, no deben cambiar el nombre de Anthonyca18m por ningún otro.**

6. Deben crear una rama donde harán sus propios cambios al proyecto, esta rama pueden llamarla como uds. Dentro de esta son libres de ramificar como prefieran, siempre y cuando nunca toquen la rama 'master' todo estará bien.

```bash
git checkout -b castillo
```

Como fue mencionado, donde dice 'castillo' pueden y deberían colocar su nombre/apellido

Una vez llegado a este paso ya hemos terminado todo para que empiecen a desarrollar de manera local sin tener que preocuparse, pero aún nos queda la parte de colaborar.

7. Cada vez que se considere necesario y sus avances estén ![alt text][oki] uds harán uso del siguiente comando:

[oki]:https://i.gyazo.com/c525c45dfacda814b97c8f9001e71676.png "oki"

```bash
git push origin castillo
```

Nuevamente recalco, donde dice 'castillo' va el nombre de SUS ramas

8. Toca ir a sus repositorios de github, ya que una vez hayan ejecutado ese comando les aparecerá algo como esto:

[pull_request]:  "pull request"

![alt text][pull_request]

9. Solo queda proseguir con colocar un buen titulo y una descripción de los cambios realizados para que Cachi deba aprobarlos y queden recepcionados en la rama master del repositorio de Cachi.

10. Una vez Cachi lo apruebe, uds harán uso de este comando

```bash
git pull main master
```

Con esto se actualizarán a los cambios que tenga el repositorio principal, y este comando les será útil cada vez que cada uno de nosotros mande nuevos cambios, para estar al día con lo que ocurre.

Si notaron algún error hacermelo saber para corregirlo o en el mejor de los casos, corregirlo uds mismos y hacer el pull request para que se actualize en el repositorio principal. ![alt text][oki]
