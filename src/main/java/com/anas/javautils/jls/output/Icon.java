package com.anas.javautils.jls.output;

import com.anas.jcolorfulconsole.lanterna.TextColor;

import java.nio.charset.StandardCharsets;

public enum Icon {

    // {} : case sensitive
    // * : any string
    // | : or

    HTML('\uf13b', new TextColor.RGB(228, 79, 57), "*.htm|*.html"),   // html
    MARKDOWN('\uf853', new TextColor.RGB(66, 165, 245), "*.md|*.markdown"),  // markdown
    CSS('\uf81b', new TextColor.RGB(66, 165, 245), "*.css"),  // css
    CSS_MAP('\ue749', new TextColor.RGB(66, 165, 245), "css.map"),  // css-map
    SASS('\ue603', new TextColor.RGB(237, 80, 122), "*.sass"),  // sass
    LESS('\ue60b', new TextColor.RGB(2, 119, 189), "*.less"),   // less
    JSON('\ue60b', new TextColor.RGB(251, 193, 60), "*.json"),  // json
    YAML('\ue60b', new TextColor.RGB(244, 68, 62), "*.yaml|*.yml"),   // yaml
    XML('\uf72d', new TextColor.RGB(64, 153, 69), "*.xml"),   // xml
    IMAGE('\uf71e', new TextColor.RGB(48, 166, 154), "*.png|*.jpg|*.jpeg|*.gif|*.bmp|*.ico"),   // image
    JAVASCRIPT('\ue74e', new TextColor.RGB(255, 202, 61), "*.js"),   // javascript
    JAVASCRIPT_MAP('\ue781', new TextColor.RGB(255, 202, 61), "js.map"),   // javascript-map
    TEST_JSX('\uf595', new TextColor.RGB(35, 188, 212), "spec.jsx|test.jsx|jsx.snap"),   // test-jsx
    TEST_JS('\uf595', new TextColor.RGB(255, 202, 61), "spec.js|e2e-spec.js|test.js|js.snap"),   // test-js
    REACT('\ue7ba', new TextColor.RGB(35, 188, 212), "*.jsx|*.tsx"),   // react
    //    REACT_TS('\ue7ba', new TextColor.RGB(36, 142, 211), ""),   // react-ts
    SETTINGS('\uf013', new TextColor.RGB(66, 165, 245), "*.settings|sln.dotsettings"),   // settings
    TYPESCRIPT('\ue628', new TextColor.RGB(3, 136, 209), "*.ts|*.tsx"),   // typescript
    TYPESCRIPT_DEF('\ufbe4', new TextColor.RGB(3, 136, 209), "*.d.ts"),   // typescript-def
    TEST_TS('\uf595', new TextColor.RGB(3, 136, 209), "spec.ts|e2e-spec.ts|test.ts|ts.snap"),   // test-ts
    PDF('\uf724', new TextColor.RGB(244, 68, 62), "*.pdf"),   // pdf
    //    TABLE('\uf71a', new TextColor.RGB(139, 195, 74)),  // table
    VISUALSTUDIO('\ue70c', new TextColor.RGB(173, 99, 188), "*.vs|*.vss|vcxitems.filters|vcxproj.filters"),   // visualstudio
    DATABASE('\ue706', new TextColor.RGB(255, 202, 61), "*.db"),   // database
    MYSQL('\ue704', new TextColor.RGB(1, 94, 134), "*.sql"),   // mysql
    //    POSTGRESQL('\ue76e', new TextColor.RGB(49, 99, 140), "*.sql"),   // postgresql
    SQLITE('\ue7c4', new TextColor.RGB(1, 57, 84), "*.sqlite"),   // sqlite
    CSHARP('\uf81a', new TextColor.RGB(2, 119, 189), "*.cs"),   // csharp
    COMPRESSED_FILE('\uf410', new TextColor.RGB(175, 180, 43), """
            *.zip|*.rar|*.7z|*.gz|*.bz2|*.xz|*.tar|*.tgz|*.z|*.tar.gz|*.tar.bz2|*.tar.xz"""),   // compressed-file
    EXE('\uf2d0', new TextColor.RGB(229, 77, 58), "*.exe|*.msi"),   // exe
    JAVA('\uf675', new TextColor.RGB(244, 68, 62), "*.java|*.class|*.jar"),   // java
    C('\ufb70', new TextColor.RGB(2, 119, 189), "*.c"),   // c
    CPP('\ufb71', new TextColor.RGB(2, 119, 189), "*.cpp"),   // cpp
    GO('\ufcd1', new TextColor.RGB(32, 173, 194), "*.go"),   // go
    GO_MOD('\ufcd1', new TextColor.RGB(237, 80, 122), "go.mod"),   // go-mod
    //    GO_TEST('\ufcd1', new TextColor.RGB(255, 213, 79), "*.go"),   // go-test
    PYTHON('\uf81f', new TextColor.RGB(52, 102, 143), "*.py"),   // python
    PYTHON_MISC('\uf820', new TextColor.RGB(130, 61, 28), "*.pyc|*.pyo"),   // python-misc
    URL('\uf836', new TextColor.RGB(66, 165, 245), "*.url"),   // url
    CONSOLE('\uf68c', new TextColor.RGB(250, 111, 66), "*.bat|*.cmd|*.sh|*.bash|*.zsh|*.ksh|*.csh|*.tcsh|*.fish|.bashrc|.zshrc|.kshrc|.cshrc|.tcshrc|.fishrc"),   // console
    WORD('\uf72b', new TextColor.RGB(1, 87, 155), "*.doc|*.docx|*.xls|*.xlsx|*.ppt|*.pptx|*.odt|*.ods|*.odp|*.odg|*.odc|*.odf|*.odb|*.rtf|*.text|*.wpd|*.wps"),   // word
    CERTIFICATE('\uf623', new TextColor.RGB(249, 89, 63), "*.cer|*.crt|*.pem|*.crl|*.crl"),   // certificate
    KEY('\uf805', new TextColor.RGB(48, 166, 154), "*.key|*.pem"),   // key
    FONT('\uf031', new TextColor.RGB(244, 68, 62), "*.ttf|*.otf|*.woff|*.woff2|*.eot|*.svg|*.ttc|*.dfont"),   // font
    LIB('\uf831', new TextColor.RGB(139, 195, 74), "*.lib|*.a|*.so|*.dll|*.dylib"),   // lib
    RUBY('\ue739', new TextColor.RGB(229, 61, 58), "*.rb|*.ruby|*.gemspec|*.rake|*.rbx|*.rbw|*.rbxl|*.rbw|*.rbxl|*.gemspec.lock|*.gemfile.lock"),   // ruby
    GEMFILE('\ue21e', new TextColor.RGB(229, 61, 58), "*.gemfile"),   // gemfile
    FSHARP('\ue7a7', new TextColor.RGB(55, 139, 186), "*.fs|*.fsx"),   // fsharp
    SWIFT('\ufbe3', new TextColor.RGB(249, 95, 63), "*.swift"),   // swift
    DOCKER('\uf308', new TextColor.RGB(1, 135, 201), "*.dockerfile"),   // docker
    POWERPOINT('\uf726', new TextColor.RGB(209, 71, 51), "*.ppt|*.pptx"),   // powerpoint
    VIDEO('\uf72a', new TextColor.RGB(253, 154, 62), """
            *.mp4|*.mkv|*.avi|*.flv|*.mov|*.wmv|*.mpg|*.mpeg|*.m4v|*.3gp|*.3g2|*.m2ts|*.mts|*.m2t"""),   // video
    //    VIRTUAL('\uf822', new TextColor.RGB(3, 155, 229)),   // virtual
    EMAIL('\uf6ed', new TextColor.RGB(66, 165, 245), "*.email|*.eml"),   // email
    AUDIO('\ufb75', new TextColor.RGB(239, 83, 80), """
            *.mp3|*.wav|*.flac|*.aac|*.ogg|*.wma|*.m4a|*.m4b|*.m4p|*.m4r|*.aif|*.aiff|*.caf|*.cda|*.mid|*.midi|*.rmi|
            *.mka|*.mpa|*.mpc|*.mp+"""),   // audio
    COFFEE('\uf675', new TextColor.RGB(66, 165, 245), "*.coffee"),   // coffee
    DOCUMENT('\uf718', new TextColor.RGB(66, 165, 245), ".text|*.txt"),   // document
    RUST('\ue7a8', new TextColor.RGB(250, 111, 66), """
            *.rs|*.rsi|*.rlib|*.rmeta|*.rmod|*.rout|*.rpass|*.rpss|*.rpssi|*.rmeta.lock|*.rlib.lock|
            *.rout.lock|*.rpass.lock|*.rpss.lock|*.rpssi.lock"""),   // rust
    RAML('\ue60b', new TextColor.RGB(66, 165, 245), "*.raml"),   // raml
    XAML('\ufb72', new TextColor.RGB(66, 165, 245), "*.xaml"),   // xaml
    HASKELL('\ue61f', new TextColor.RGB(254, 168, 62), "*.hs|*.lhs"),   // haskell
    GIT('\ue702', new TextColor.RGB(229, 77, 58), """
            *.gitignore|*.gitattributes|*.gitmodules|*.gitignore.global|*.gitattributes.global|*.gitmodules.global"""),   // git
    LUA('\ue620', new TextColor.RGB(66, 165, 245), "*.lua"),   // lua
    CLOJURE('\ue76a', new TextColor.RGB(100, 221, 23), "*.clj|*.cljs|*.cljc"),   // clojure
    GROOVY('\uf2a6', new TextColor.RGB(41, 198, 218), "*.groovy"),   // groovy
    R('\ufcd2', new TextColor.RGB(25, 118, 210), "*.r"),   // r
    DART('\ue798', new TextColor.RGB(87, 182, 240), "*.dart"),   // dart
    MXML('\uf72d', new TextColor.RGB(254, 168, 62), "*.mxml"),   // mxml
    ASSEMBLY('\uf471', new TextColor.RGB(250, 109, 63), "*.asm|*.nasm"),   // assembly
    GRADLE('\uE608', new TextColor.RGB(29, 151, 167), "*.gradle"),   // gradle
    ROUTING('\ufb40', new TextColor.RGB(67, 160, 71), """
            routing.ts|routing.js|routing.tsx|routes.ts|routes.tsx|routes.js|routing.jsx|routes.jsx"""),   // routing
    LARAVEL('\ue73f', new TextColor.RGB(248, 80, 81), "blade.php|inky.php"),   // laravel
    GITLAB('\uf296', new TextColor.RGB(226, 69, 57), "*.gitlab-ci.yml"),   // gitlab
    AZURE_PIPELINES('\uf427', new TextColor.RGB(20, 101, 192), "azure-pipelines.yml|azure-pipelines.yaml"),   // azure pipelines
    GIT_DIR('\uE5FB', new TextColor.RGB(229, 77, 58), ".git"),   // git dir
    CONFIG_DIR('\ue5fc', new TextColor.RGB(32, 173, 194), ".config"),   // config dir
    CONTROLLER_DIR('\ue5fc', new TextColor.RGB(255, 194, 61), "controllers"),   // controller dir
    GITHUB_DIR('\ue5fd', new TextColor.RGB(84, 110, 122), ".github"),   // github dir
    NPM_DIR('\ue5fa', new TextColor.RGB(203, 56, 55), ".npm"),   // npm dir
    INCLUDE_DIR('\uf756', new TextColor.RGB(3, 155, 229), "include"),   // include dir
    IMPORT_DIR('\uf756', new TextColor.RGB(175, 180, 43), "import"),   // import dir
    UPLOAD_DIR('\uf758', new TextColor.RGB(250, 111, 66), "upload"),   // upload dir
    DOWNLOAD_DIR('\uf74c', new TextColor.RGB(76, 175, 80), "{Downloads}"),   // download dir
    SECURE_DIR('\uf74f', new TextColor.RGB(249, 169, 60), "secure"),   // secure dir
    IMAGES_DIR('\uf74e', new TextColor.RGB(43, 150, 137), "{Pictures}"),   // images dir
    ENVIRONMENT_DIR('\uf74e', new TextColor.RGB(102, 187, 106), "environment"),   // environment dir
    IDEA_DIR('\uE7B5', new TextColor.RGB(224, 177, 77), ".idea"),   // idea dir

    // Default icons
    DIR('\uf74a', new TextColor.RGB(224, 177, 77), ""),   // dir
    DIR_OPEN('\ufc6e', new TextColor.RGB(224, 177, 77), ""),   // dir open
    HIDDEN_DIR('\uf755', new TextColor.RGB(224, 177, 77), ""),   // hidden dir
    EXECUTABLE('\uf713', new TextColor.RGB(76, 175, 80), ""),   // executable
    FILE('\uf723', new TextColor.RGB(65, 129, 190), ""),   // file
    HIDDEN_FILE('\ufb12', new TextColor.RGB(65, 129, 190), ""),   // hidden file
    /*VUE('\ufd42', new TextColor.RGB(65, 184, 131)),  // vue
    ('\ufd42', new TextColor.RGB(58, 121, 110)),  // vue-config
            ('\uf83d', new TextColor.RGB(255, 213, 79)),  // lock
            ('\ue60f', new TextColor.RGB(250, 111, 66)),  // handlebars
            ('\ue769', new TextColor.RGB(149, 117, 205)), // perl
            ('\ue62d', new TextColor.RGB(149, 117, 205)), // elixir
            ('\ue7b1', new TextColor.RGB(244, 68, 62)),   // erlang
            ('\ue61c', new TextColor.RGB(155, 185, 47)),  // twig
            ('\ue624', new TextColor.RGB(134, 82, 159)),  // julia
            ('\ue62c', new TextColor.RGB(96, 181, 204)),  // elm
            ('\uf834', new TextColor.RGB(255, 207, 60)),  // smarty
            ('\ue600', new TextColor.RGB(192, 202, 51)),  // stylus
            ('\ufb19', new TextColor.RGB(250, 111, 66)),  // verilog
            ('\ufba7', new TextColor.RGB(249, 89, 63)),   // robot
            ('\ufcb9', new TextColor.RGB(3, 136, 209)),   // solidity
            ('\ufb7e', new TextColor.RGB(66, 165, 245)),  // yang
            ('\uf47e', new TextColor.RGB(207, 216, 220)), // vercel
            ('\uf302', new TextColor.RGB(120, 144, 156)), // applescript
            ('\uf5ea', new TextColor.RGB(250, 111, 66)),  // cake
            ('\uf6a4', new TextColor.RGB(255, 202, 61)),  // nim
            ('\uf058', new TextColor.RGB(124, 179, 66)),  // todo
            ('\uf313', new TextColor.RGB(80, 117, 193)),  // nix
            ('\uf484', new TextColor.RGB(66, 165, 245)),  // http
            ('\ufc29', new TextColor.RGB(142, 214, 251)), // webpack
            ('\ue7a9', new TextColor.RGB(79, 143, 247)),  // ionic
            ('\ue763', new TextColor.RGB(229, 61, 58)),   // gulp
            ('\uf898', new TextColor.RGB(139, 195, 74)),  // nodejs
            ('\ue71e', new TextColor.RGB(203, 56, 55)),   // npm
            ('\uf61a', new TextColor.RGB(44, 142, 187)),  // yarn
            ('\uf531', new TextColor.RGB(139, 195, 74)),  // android
            ('\ufb69', new TextColor.RGB(251, 193, 60)),  // tune
            ('\uf64d', new TextColor.RGB(255, 202, 61)),  // contributing
            ('\uf7fb', new TextColor.RGB(66, 165, 245)),  // readme
            ('\ufba6', new TextColor.RGB(139, 195, 74)),  // changelog
            ('\uf75f', new TextColor.RGB(156, 204, 101)), // credits
            ('\uf0c0', new TextColor.RGB(244, 68, 62)),   // authors
            ('\ue623', new TextColor.RGB(255, 213, 79)),  // favicon
            ('\ue622', new TextColor.RGB(60, 190, 174)),  // karma
            ('\ue77e', new TextColor.RGB(203, 58, 73)),   // travis
            ('\ue607', new TextColor.RGB(105, 99, 185)),  // heroku
            ('\ue61a', new TextColor.RGB(239, 88, 60)),   // bower
            ('\uf64b', new TextColor.RGB(205, 220, 57)),  // conduct
            ('\ue767', new TextColor.RGB(240, 214, 183)), // jenkins
            ('\uf7f4', new TextColor.RGB(238, 238, 238)), // code-climate
            ('\uf719', new TextColor.RGB(175, 180, 43)),  // log
            ('\ue618', new TextColor.RGB(255, 202, 61)),  // ejs
            ('\ue611', new TextColor.RGB(251, 170, 61)),  // grunt
            ('\ue71d', new TextColor.RGB(67, 160, 71)),   // django
            ('\uf728', new TextColor.RGB(239, 83, 80)),   // makefile
            ('\uf171', new TextColor.RGB(31, 136, 229)),  // bitbucket
            ('\ue7af', new TextColor.RGB(244, 68, 62)),   // d
            ('\uf853', new TextColor.RGB(255, 202, 61)),  // mdx
            ('\ufd03', new TextColor.RGB(31, 136, 229)),  // azure
            ('\uf564', new TextColor.RGB(66, 165, 245)),  // razor
            ('\uf718', new TextColor.RGB(244, 68, 62)),   // asciidoc
            ('\uf564', new TextColor.RGB(239, 111, 60)),  // edge
            ('\ufb26', new TextColor.RGB(244, 68, 62)),   // scheme
            ('\ue79b', new TextColor.RGB(40, 182, 246)),  // 3d
            ('\ufc1f', new TextColor.RGB(255, 181, 62)),  // svg
            ('\ue62b', new TextColor.RGB(67, 160, 71)),   // vim
            ('\uf186', new TextColor.RGB(251, 193, 60)),  // moonscript
            ('\uf507', new TextColor.RGB(175, 180, 43)),  // codeowners
            ('\ue271', new TextColor.RGB(176, 190, 197)), // disc
            F', new TextColor.RGB(250, 111, 66)),       // fortran
            ('\ufbd1', new TextColor.RGB(239, 83, 80)),   // tcl
            ('\ue275', new TextColor.RGB(40, 182, 246)),  // liquid
            ('\ue7a1', new TextColor.RGB(239, 83, 80)),   // prolog
            ('\uf8e8', new TextColor.RGB(229, 229, 229)), // husky
            ('\uf5d2', new TextColor.RGB(141, 110, 99)),  // coconut
            ('\uf6c7', new TextColor.RGB(255, 194, 61)),  // sketch
            ('\ue261', new TextColor.RGB(239, 111, 60)),  // pawn
            ('\ufc16', new TextColor.RGB(43, 150, 137)),  // commitlint
            ('\uf448', new TextColor.RGB(120, 144, 156)), // dhall
            ('\uf7f4', new TextColor.RGB(244, 127, 61)),  // dune
            ('\ufbad', new TextColor.RGB(25, 118, 210)),  // shaderlab
            ('\ufb32', new TextColor.RGB(175, 188, 194)), // command
            ('\uf05b', new TextColor.RGB(239, 83, 80)),   // stryker
            ('\ue720', new TextColor.RGB(234, 72, 99)),   // modernizr
            ('\ufb6d', new TextColor.RGB(48, 166, 154)),  // roadmap
            ('\uf306', new TextColor.RGB(211, 61, 76)),   // debian
            ('\uf31c', new TextColor.RGB(214, 73, 53)),   // ubuntu
            ('\uf303', new TextColor.RGB(33, 142, 202)),  // arch
            ('\uf316', new TextColor.RGB(231, 61, 58)),   // redhat
            ('\uf30d', new TextColor.RGB(148, 141, 211)), // gentoo
            ('\ue712', new TextColor.RGB(238, 207, 55)),  // linux
            ('\uf315', new TextColor.RGB(208, 60, 76)),   // raspberry-pi
            ('\uf312', new TextColor.RGB(73, 185, 90)),   // manjaro
            ('\uf314', new TextColor.RGB(111, 180, 36)),  // opensuse
            ('\uf30a', new TextColor.RGB(52, 103, 172)),  // fedora
            ('\uf30c', new TextColor.RGB(175, 44, 42)),   // freebsd
            ('\uf304', new TextColor.RGB(157, 83, 135)),  // centOS
            ('\uf300', new TextColor.RGB(14, 87, 123)),   // alpine
            ('\uf30f', new TextColor.RGB(125, 190, 58)),  // mint
            ('\ue60e', new TextColor.RGB(239, 204, 163)), // pug (Not supported by nerdFont)
            ('\uf72a', new TextColor.RGB(249, 169, 60)),  // blink (The Foundry Nuke) (Not supported by nerdFont)
            ('\uf81b', new TextColor.RGB(244, 68, 62)),   // postcss (Not supported by nerdFont)
            ('\ue000', new TextColor.RGB(174, 44, 42)),   // jinja (Not supported by nerdFont)
            ('\ue7aa', new TextColor.RGB(239, 148, 58)),  // sublime (Not supported by nerdFont)
            ('\uf13b', new TextColor.RGB(2, 119, 189)),   // markojs (Not supported by nerdFont)
            ('\ue70c', new TextColor.RGB(33, 150, 243)),  // vscode (Not supported by nerdFont)
            ('\uf292', new TextColor.RGB(251, 193, 60)),  // qsharp (Not supported by nerdFont)
            ('\uf7ab', new TextColor.RGB(149, 117, 205)), // vala (Not supported by nerdFont)
            Z', new TextColor.RGB(249, 169, 60)),       // zig (Not supported by nerdFont)
            h', new TextColor.RGB(2, 119, 189)),        // h (Not supported by nerdFont)
            h', new TextColor.RGB(2, 119, 189)),        // hpp (Not supported by nerdFont)
            ('\ufcb5', new TextColor.RGB(5, 169, 244)),   // powershell (Not supported by nerdFont)
            ('\ufcc4', new TextColor.RGB(29, 151, 167)),  // gradle (Not supported by nerdFont)
            ('\ue255', new TextColor.RGB(35, 151, 156)),  // arduino (Not supported by nerdFont)
            ('\uf783', new TextColor.RGB(66, 165, 245)),  // tex (Not supported by nerdFont)
            ('\ue284', new TextColor.RGB(237, 80, 122)),  // graphql (Not supported by nerdFont)
            ('\ue70e', new TextColor.RGB(139, 195, 74)),  // kotlin (Not supported by nerdFont)
            ('\ufb25', new TextColor.RGB(244, 68, 62)),   // actionscript (Not supported by nerdFont)
            ('\uf812', new TextColor.RGB(76, 175, 80)),   // autohotkey (Not supported by nerdFont)
            ('\uf740', new TextColor.RGB(198, 52, 54)),   // flash (Not supported by nerdFont)
            ('\ufbd3', new TextColor.RGB(198, 52, 54)),   // swc (Not supported by nerdFont)
            ('\uf425', new TextColor.RGB(178, 178, 179)), // cmake (Not supported by nerdFont)
            ('\ue2a6', new TextColor.RGB(65, 184, 131)),  // nuxt (Not supported by nerdFont)
            ('\uf1ce', new TextColor.RGB(253, 154, 62)),  // ocaml (Not supported by nerdFont)
            ('\uf425', new TextColor.RGB(246, 137, 61)),  // haxe (Not supported by nerdFont)
            ('\uf595', new TextColor.RGB(251, 193, 60)),  // puppet (Not supported by nerdFont)
            ('\uf670', new TextColor.RGB(66, 165, 245)),  // purescript (Not supported by nerdFont)
            ('\uf136', new TextColor.RGB(66, 165, 245)),  // merlin (Not supported by nerdFont)
            ('\ue714', new TextColor.RGB(249, 89, 63)),   // mjml (Not supported by nerdFont)
            ('\ue20f', new TextColor.RGB(92, 107, 192)),  // terraform (Not supported by nerdFont)
            ('\uf031', new TextColor.RGB(66, 165, 245)),  // apiblueprint (Not supported by nerdFont)
            ('\uf24e', new TextColor.RGB(245, 129, 61)),  // slim (Not supported by nerdFont)
            ('\uf5a0', new TextColor.RGB(253, 217, 59)),  // babel (Not supported by nerdFont)
            ('\ue37c', new TextColor.RGB(237, 80, 122)),  // codecov (Not supported by nerdFont)
            ('\uf288', new TextColor.RGB(229, 61, 58)),   // protractor (Not supported by nerdFont)
            ('\ufbf6', new TextColor.RGB(121, 134, 203)), // eslint (Not supported by nerdFont)
            ('\uf6a9', new TextColor.RGB(161, 136, 127)), // mocha (Not supported by nerdFont)
            ('\ue787', new TextColor.RGB(251, 193, 60)),  // firebase (Not supported by nerdFont)
            ('\ufb76', new TextColor.RGB(207, 216, 220)), // stylelint (Not supported by nerdFont)
            ('\uf8e2', new TextColor.RGB(86, 179, 180)),  // prettier (Not supported by nerdFont)
            J', new TextColor.RGB(244, 85, 62)),        // jest (Not supported by nerdFont)
            ('\ufd2c', new TextColor.RGB(237, 80, 122)),  // storybook (Not supported by nerdFont)
            ('\ufbff', new TextColor.RGB(149, 119, 232)), // fastlane (Not supported by nerdFont)
            ('\ufd31', new TextColor.RGB(32, 173, 194)),  // helm (Not supported by nerdFont)
            ('\uf7be', new TextColor.RGB(121, 134, 203)), // i18n (Not supported by nerdFont)
            ('\uf70f', new TextColor.RGB(245, 245, 245)), // semantic-release (Not supported by nerdFont)
            ('\ufba7', new TextColor.RGB(79, 195, 247)),  // godot (Not supported by nerdFont)
            ('\ufba7', new TextColor.RGB(129, 199, 132)), // godot-assets (Not supported by nerdFont)
            ('\uf27d', new TextColor.RGB(20, 101, 192)),  // vagrant (Not supported by nerdFont)
            ('\ufc8b', new TextColor.RGB(77, 182, 172)),  // tailwindcss (Not supported by nerdFont)
            ('\uf662', new TextColor.RGB(70, 136, 250)),  // gcp (Not supported by nerdFont)
            ('\uf1ce', new TextColor.RGB(255, 213, 79)),  // opam (Not supported by nerdFont)
            ('\uf8da', new TextColor.RGB(3, 136, 209)),   // pascal (Not supported by nerdFont)
            ('\ue77f', new TextColor.RGB(3, 136, 209)),   // nuget (Not supported by nerdFont)
            */;
    private final char icon;
    private final TextColor color;
    private final String pattern;

    Icon(final char icon,
         final TextColor color,
         final String pattern) {
        this.icon = icon;
        this.color = color;
        this.pattern = pattern;
    }

    /**
     * Checking the file extension and returning the appropriate icon.
     *
     * @param fileName The file name to check.
     * @return The icon for the file, null if no icon is found.
     */
    public static Icon getCorrectIcon(final String fileName) {
        for (Icon icon : values()) {
            if (icon.matches(fileName)) {
                return icon;
            }
        }
        return null;
    }

    /**
     * Get the icon code.
     * @return The icon code.
     */
    public char getIcon() {
        return icon;
    }

    /**
     * Get the icon color.
     * @return The icon color.
     */
    public TextColor getColor() {
        return color;
    }

    /**
     * Get the icon pattern.
     * @return The icon pattern.
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Check if the file name matches the pattern.
     *
     * @param fileName The file name to check.
     * @return True if the file name matches the pattern, false otherwise.
     */
    // TODO: 6/21/22 Fix case sensitive matching :)
    private boolean matches(final String fileName) {
        for (String pat : pattern.split("\\|")) {
            boolean caseSensitive = pat.startsWith(("{")) && pat.endsWith(("}"));
            if (caseSensitive) {
                pat = pat.substring(1, pat.length() - 1);
            }
            if (pat.startsWith("*")) {
                pat = pat.substring(1);
                if ((!caseSensitive && fileName.toLowerCase().endsWith(pat)) ||
                        (caseSensitive && fileName.endsWith(pat))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Get the icon with the icon color.
     * @return The icon with the icon color.
     */
    @Override
    public String toString() {
        return "\033[" +
                new String(color.getForegroundSGRSequence(), StandardCharsets.UTF_8) + "m" +
                icon + "\033[0m";
    }

    /**
     * Get the icon without color.
     * @return the icon char without color.
     */
    public String getNoColoredIcon() {
        return icon + "";
    }
}
