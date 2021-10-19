package com.example.flicker_xml


import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "MethodResponse",strict = false)
class MethodResponse @JvmOverloads constructor(
        @field:Element(required = false, name = "params")
        @param:Element(name = "params")
        val params: Params
    )

{
    @Root(name = "params",strict = false)
    class Params constructor(
        @field:Element(required = false, name= "param")
        @param:Element(name = "param")
        val param: Param
    ) {
        @Root(name = "param",strict = false)
        class Param constructor(
            @field:Element(required = false, name= "value")
            @param:Element(name = "value")
            val value: Value
        ) {
            @Root(name = "value",strict = false)
            class Value constructor(
                @field:Element(required = false, name= "string")
                @param:Element(name = "string")
                val string: StringClass
            ) {
                @Root(name = "string",strict = false)
                class StringClass constructor(
                    @field:Element(required = false, name= "photos")
                    @param:Element(name = "photos")
                    val photos: Photos
                ) {
                    @Root(name = "photos",strict = false)
                    class Photos constructor(
                        val photo: List<Photo>,

                        @field:Element(required = false, name= "_page")
                         @param:Element(name = "_page")
                        val page: String,

                        @field:Element(required = false, name= "_pages")
                        @param:Element(name = "_pages")
                        val pages: String,

                        @field:Element(required = false, name= "_perpage")
                        @param:Element(name = "_perpage")
                        val perpage: String,

                        @field:Element(required = false, name= "_total")
                        @param:Element(name = "_total")
                        val total: String
                    ) {
                        @Root(name = "photo",strict = false)
                        class Photo constructor(
                            @field:Element(required = false, name= "_id")
                            @param:Element(name = "_id")
                            val id: String,

                            @field:Element(required = false, name= "_owner")
                            @param:Element(name = "_owner")
                            val owner: String,

                            @field:Element(required = false, name= "_secret")
                            @param:Element(name = "_secret")
                            val secret: String,

                            @field:Element(required = false, name= "_server")
                            @param:Element(name = "_server")
                            val server: String,

                            @field:Element(required = false, name= "_farm")
                            @param:Element(name = "_farm")
                            val farm: String,

                            @field:Element(required = false, name= "_title")
                            @param:Element(name = "_title")
                            val title: String,

                            @field:Element(required = false, name= "_ispublic")
                            @param:Element(name = "_ispublic")
                            val ispublic: String,

                            @field:Element(required = false, name= "_isfriend")
                            @param:Element(name = "_isfriend")
                            val isfriend: String,

                            @field:Element(required = false, name= "_isfamily")
                            @param:Element(name = "_isfamily")
                            val isfamily: String
                        ) {

                        }
                    }
                }
            }
        }
    }
}


