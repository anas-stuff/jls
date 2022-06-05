package com.anas.javautils.jls.output;

import com.googlecode.lanterna.TextColor;

public enum Icons {
    HTML('\uf13b', new TextColor.RGB(228, 79, 57)),   // html
    MARKDOWN('\uf853', new TextColor.RGB(66, 165, 245)),  // markdown
    CSS('\uf81b', new TextColor.RGB(66, 165, 245)),  // css
    CSS_MAP('\ue749', new TextColor.RGB(66, 165, 245)),  // css-map
    SASS('\ue603', new TextColor.RGB(237, 80, 122)),  // sass
    LESS('\ue60b', new TextColor.RGB(2, 119, 189)),   // less
    JSON('\ue60b', new TextColor.RGB(251, 193, 60)),  // json
    YAML('\ue60b', new TextColor.RGB(244, 68, 62)),   // yaml
    XML('\uf72d', new TextColor.RGB(64, 153, 69)),   // xml
    IMAGE('\uf71e', new TextColor.RGB(48, 166, 154)),  // image
    JAVASCRIPT('\ue74e', new TextColor.RGB(255, 202, 61)),  // javascript
    JAVASCRIPT_MAP('\ue781', new TextColor.RGB(255, 202, 61)),  // javascript-map
    TEST_JSX('\uf595', new TextColor.RGB(35, 188, 212)),  // test-jsx
    TEST_JS('\uf595', new TextColor.RGB(255, 202, 61)),  // test-js
    REACT('\ue7ba', new TextColor.RGB(35, 188, 212)),  // react
    REACT_TS('\ue7ba', new TextColor.RGB(36, 142, 211)),  // react_ts
    SETTINGS('\uf013', new TextColor.RGB(66, 165, 245)),  // settings
    TYPESCRIPT('\ue628', new TextColor.RGB(3, 136, 209)),   // typescript
    TYPESCRIPT_DEF('\ufbe4', new TextColor.RGB(3, 136, 209)),   // typescript-def
    TEST_TS('\uf595', new TextColor.RGB(3, 136, 209)),   // test-ts
    PDF('\uf724', new TextColor.RGB(244, 68, 62)),   // pdf
    TABLE('\uf71a', new TextColor.RGB(139, 195, 74)),  // table
    VISUALSTUDIO('\ue70c', new TextColor.RGB(173, 99, 188)),  // visualstudio
    DATABASE('\ue706', new TextColor.RGB(255, 202, 61)),  // database
    MYSQL('\ue704', new TextColor.RGB(1, 94, 134)),    // mysql
    POSTGRESQL('\ue76e', new TextColor.RGB(49, 99, 140)),   // postgresql
    SQLITE('\ue7c4', new TextColor.RGB(1, 57, 84)),     // sqlite
    CSHARP('\uf81a', new TextColor.RGB(2, 119, 189)),   // csharp
    ZIP('\uf410', new TextColor.RGB(175, 180, 43)),  // zip
    EXE('\uf2d0', new TextColor.RGB(229, 77, 58)),   // exe
    JAVA('\uf675', new TextColor.RGB(244, 68, 62)),   // java
    C('\ufb70', new TextColor.RGB(2, 119, 189)),   // c
    CPP('\ufb71', new TextColor.RGB(2, 119, 189)),   // cpp
    GO('\ufcd1', new TextColor.RGB(32, 173, 194)),  // go
    GO_MOD('\ufcd1', new TextColor.RGB(237, 80, 122)),  // go-mod
    GO_TEST('\ufcd1', new TextColor.RGB(255, 213, 79)),  // go-test
    PYTHON('\uf81f', new TextColor.RGB(52, 102, 143)),  // python
    PYTHON_MISC('\uf820', new TextColor.RGB(130, 61, 28)),   // python-misc
    URL('\uf836', new TextColor.RGB(66, 165, 245)),  // url
    CONSOLE('\uf68c', new TextColor.RGB(250, 111, 66)),  // console
    WORD('\uf72b', new TextColor.RGB(1, 87, 155)),    // word
    CERTIFICATE('\uf623', new TextColor.RGB(249, 89, 63)),   // certificate
    KEY('\uf805', new TextColor.RGB(48, 166, 154)),  // key
    FONT('\uf031', new TextColor.RGB(244, 68, 62)),   // font
    LIB('\uf831', new TextColor.RGB(139, 195, 74)),  // lib
    RUBY('\ue739', new TextColor.RGB(229, 61, 58)),   // ruby
    GEMFILE('\ue21e', new TextColor.RGB(229, 61, 58)),   // gemfile
    FSHARP('\ue7a7', new TextColor.RGB(55, 139, 186)),  // fsharp
    SWIFT('\ufbe3', new TextColor.RGB(249, 95, 63)),   // swift
    DOCKER('\uf308', new TextColor.RGB(1, 135, 201)),   // docker
    POWERPOINT('\uf726', new TextColor.RGB(209, 71, 51)),   // powerpoint
    VIDEO('\uf72a', new TextColor.RGB(253, 154, 62)),  // video
    VIRTUAL('\uf822', new TextColor.RGB(3, 155, 229)),   // virtual
    EMAIL('\uf6ed', new TextColor.RGB(66, 165, 245)),  // email
    AUDIO('\ufb75', new TextColor.RGB(239, 83, 80)),   // audio
    COFFEE('\uf675', new TextColor.RGB(66, 165, 245)),  // coffee
    DOCUMENT('\uf718', new TextColor.RGB(66, 165, 245)),  // document
    RUST('\ue7a8', new TextColor.RGB(250, 111, 66)),  // rust
    RAML('\ue60b', new TextColor.RGB(66, 165, 245)),  // raml
    XAML('\ufb72', new TextColor.RGB(66, 165, 245)),  // xaml
    HASKELL('\ue61f', new TextColor.RGB(254, 168, 62)),  // haskell
    GIT('\ue702', new TextColor.RGB(229, 77, 58)),   // git
    LUA('\ue620', new TextColor.RGB(66, 165, 245)),  // lua
    CLOJURE('\ue76a', new TextColor.RGB(100, 221, 23)),  // clojure
    GROOVY('\uf2a6', new TextColor.RGB(41, 198, 218)),  // groovy
    R('\ufcd2', new TextColor.RGB(25, 118, 210)),  // r
    DART('\ue798', new TextColor.RGB(87, 182, 240)),  // dart
    MXML('\uf72d', new TextColor.RGB(254, 168, 62)),  // mxml
    ASSEMBLY('\uf471', new TextColor.RGB(250, 109, 63)),  // assembly
    GRADLE('\uE608', new TextColor.RGB(29, 151, 167)),  // gradle
    ROUTING('\ufb40', new TextColor.RGB(67, 160, 71)),   // routing
    LARAVEL('\ue73f', new TextColor.RGB(248, 80, 81)),   // laravel
    GITLAB('\uf296', new TextColor.RGB(226, 69, 57)),   // gitlab
    AZURE_PIPELINES('\uf427', new TextColor.RGB(20, 101, 192)),  // azure-pipelines

    // Default icons
    DIR('\uf74a', new TextColor.RGB(224, 177, 77)),
    DIR_OPEN('\ufc6e', new TextColor.RGB(224, 177, 77)),
    HIDDEN_DIR('\uf755', new TextColor.RGB(224, 177, 77)),
    EXECUTABLE('\uf713', new TextColor.RGB(76, 175, 80)),
    FILE('\uf723', new TextColor.RGB(65, 129, 190)),
    HIDDEN_FILE('\ufb12', new TextColor.RGB(65, 129, 190)),
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
            ('\ue5fc', new TextColor.RGB(32, 173, 194)),  // dir-config('\ue5fc', new TextColor.RGB(255, 194, 61)),  // dir-controller
            ('\ue5fb', new TextColor.RGB(250, 111, 66)),  // dir-git
            ('\ue5fd', new TextColor.RGB(84, 110, 122)),  // dir-github
            ('\ue5fa', new TextColor.RGB(203, 56, 55)),   // dir-npm
            ('\uf756', new TextColor.RGB(3, 155, 229)),   // dir-include
            ('\uf756', new TextColor.RGB(175, 180, 43)),  // dir-import
            ('\uf758', new TextColor.RGB(250, 111, 66)),  // dir-upload
            ('\uf74c', new TextColor.RGB(76, 175, 80)),   // dir-download
            ('\uf74f', new TextColor.RGB(249, 169, 60)),  // dir-secure
            ('\uf74e', new TextColor.RGB(43, 150, 137)),  // dir-images
            ('\uf74e', new TextColor.RGB(102, 187, 106)), // dir-environment*/
    ;
    private final char icon;
    private final TextColor.RGB color;

    Icons(char icon, TextColor.RGB color) {
        this.icon = icon;
        this.color = color;
    }

    public char getIcon() {
        return icon;
    }

    public TextColor.RGB getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "\033[" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m" + icon + "\033[0m";
    }
}
