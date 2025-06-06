Feature: Pruebas de la API de Demoblaze

Scenario: Crear un nuevo usuario en signup
  Given url 'https://api.demoblaze.com/signup'
  And request { username: 'alexkarate1', password: 'Test1234' }
  When method post
  Then status 200
  And print response

Scenario: Intentar crear un usuario ya existente
  Given url 'https://api.demoblaze.com/signup'
  And request { username: 'alexkarate1', password: 'Test1234' }
  When method post
  Then status 200
  And print response

Scenario: Login exitoso con usuario válido
  Given url 'https://api.demoblaze.com/login'
  And request { username: 'alexkarate1', password: 'Test1234' }
  When method post
  Then status 200
  And print response

Scenario: Login con usuario o contraseña incorrectos
  Given url 'https://api.demoblaze.com/login'
  And request { username: 'alexkarate1', password: 'ContraseñaIncorrecta' }
  When method post
  Then status 200
  And print response