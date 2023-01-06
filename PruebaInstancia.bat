echo Prueba de Instancias

CD build
CD install
CD mp01
start java -Dserver.port=7010 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=7011 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=7012 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=7013 -classpath lib/* com.distribuida.Servidor