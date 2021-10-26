package com.example.flicker_xml


import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "MethodResponse",strict = false)
class MethodResponse @JvmOverloads constructor(
        @field:Element(required = false, name = "params")
        var params: Params? = null
    ): Serializable


    @Root(name = "params", strict = false)
    class Params constructor(
        @field:Element(required = false, name = "param")
        var param: Param? = null
    ): Serializable

    @Root(name = "param", strict = false)
    class Param constructor(
        @field:Element(required = false, name = "value")
        var value: Value? = null
    ): Serializable

    @Root(name = "value", strict = false)
    class Value constructor(
        @field:Element(required = false, name = "string")
        var string: str? = null
    ): Serializable

    @Root(name = "string", strict = false)
    class str constructor(
        @field:Element(required = false, name = "photos")
        var photos: Photos? = null
    ): Serializable

    @Root(name = "photos", strict = false)
    class Photos constructor(
        @field:ElementList(inline=true, name = "photo")
        var photo: List<Photo>? = null,

        @field:Attribute(required = false, name = "page")
        var page: String? = null,

        @field:Attribute(required = false, name = "pages")
        var pages: String? = null,

        @field:Attribute(required = false, name = "perpage")
        var perpage: String? = null,

        @field:Attribute(required = false, name = "total")
        var total: String? = null
    ): Serializable

    @Root(name = "photo", strict = false)
    class Photo constructor(
        @field:Attribute(required = false, name = "id")
        var id: String? = null,

        @field:Attribute(required = false, name = "owner")
        var owner: String? = null,

        @field:Attribute(required = false, name = "secret")
        var secret: String? = null,

        @field:Attribute(required = false, name = "server")
        var server: String? = null,

        @field:Attribute(required = false, name = "farm")
        var farm: String? = null,

        @field:Attribute(required = false, name = "title")
        var title: String? = null,

        @field:Attribute(required = false, name = "ispublic")
        var ispublic: String? = null,

        @field:Attribute(required = false, name = "isfriend")
        var isfriend: String? = null,

        @field:Attribute(required = false, name = "isfamily")
        var isfamily: String? = null
    ): Serializable





