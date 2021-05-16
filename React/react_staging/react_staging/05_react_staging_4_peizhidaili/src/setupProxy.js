const proxy = require("http-proxy-middleWare");
module.exports = function (app) {
  app.use(
    proxy("/app1", {
      target: "http://localhost:5000",
      changeOrigin: true,
      pathRewrite: { "^/app1": "" },
    }),
    proxy("/app2", {
      target: "http://localhost:5001",
      changeOrigin: true,
      pathRewrite: { "^/app2": "" },
    })
  );
};
